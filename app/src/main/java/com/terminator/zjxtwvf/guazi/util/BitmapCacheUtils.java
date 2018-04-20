package com.terminator.zjxtwvf.guazi.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;

public class BitmapCacheUtils {

	public static final String SDPATH = Environment.getExternalStorageDirectory().getAbsolutePath();

	public static final String ADPATH = SDPATH + "/Guazhi";
	
	private LruCache<String, Bitmap> mCache;
	private HashMap<ImageView, String> mHashMap = new HashMap<ImageView, String>();
	
	private static BitmapCacheUtils mCacheUtils;

    	
	private BitmapCacheUtils(){
		long maxSize = Runtime.getRuntime().maxMemory();
		mCache = new LruCache<String, Bitmap>((int)(maxSize/8)){
			@Override
			protected int sizeOf(String key, Bitmap bitmap) {
				return bitmap.getByteCount();
			}
			@Override
			protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue){
				System.out.println("bitmap is recycled --------------------------->>>>>"  + oldValue.toString());
				if(null != oldValue){
					//oldValue.recycle();
				}
			}
		};
	}
	
	public static BitmapCacheUtils getInstance(){
		if(mCacheUtils != null){
			return mCacheUtils;
		}
		mCacheUtils = new BitmapCacheUtils();
		return mCacheUtils;
	}

	public void display(final ImageView imageView,final String url){
		Glide.with(UIUtils.getContext())
				.load(url)
				.into(imageView);
	}

	public void display01(final ImageView imageView,final String url){
		final Bitmap bitmap[] = {null};
		mHashMap.put(imageView, url);
		//从内存获取
		bitmap[0] = getFromMap(url);
		if(bitmap != null && null != bitmap[0]){
			System.out.println("from memoty ---------------->>>>>" + bitmap[0].toString() +"   " +Md5Utils.md5(url));
			imageView.setImageBitmap(bitmap[0]);
			return;
		}
		//从SD卡获取
		if((null == bitmap[0]) && ((bitmap[0] = getFromFile(url)) != null)){
			setBitmapToMap(bitmap[0],url);
			UIUtils.runOnUIThread(new Runnable() {
				@Override
				public void run() {
					if(url.equals(mHashMap.get(imageView))){
						System.out.println("from SD ---------------->>>>>" + bitmap[0].toString()  +"   " +Md5Utils.md5(url));
						imageView.setImageBitmap(bitmap[0]);
					}
				}
			});
		}
		//从网络获取
		if((null == bitmap[0])){
			getFromNet(imageView,url,false);
		}
	}

	private void setBitmapToFile(Bitmap bitmap, String url) {
		File file = new File(ADPATH);
		if (!file.exists()) {
			boolean create = file.mkdirs();
			Logger.d("create = " + create);
		} else {
			if (!file.isDirectory()) {
				file.delete();
				file.mkdir();
			}
		}
		File iamge = new File(ADPATH + "/"+Md5Utils.md5(url)+".png");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(iamge);
			bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		}
		
	}

	private void setBitmapToMap(Bitmap bitmap, String url) {
		mCache.put(Md5Utils.md5(url), bitmap);
	}

	private void getFromNet(final ImageView imageView,final String url,final boolean ifMatchWidth) {
		ThreadManager.getThreadPool().execute(new Runnable() {
			Bitmap bitmap = null;
			@Override
			public void run() {
				try {
					URL url2 = new URL(url);
					HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
					connection.setConnectTimeout(5000);
					connection.setRequestMethod("GET");
					if(connection.getResponseCode() != 200){
						return;
					}
					InputStream inputStream = connection.getInputStream();
					if(null != inputStream){
						bitmap = BitmapFactory.decodeStream(inputStream);
						setBitmapToMap(bitmap,url);
						setBitmapToFile(bitmap,url);
						UIUtils.runOnUIThread(new Runnable() {
							@Override
							public void run() {
								if(url.equals(mHashMap.get(imageView))){
									imageView.setImageBitmap(bitmap);
									if(ifMatchWidth){
										UIUtils.setImageMatchWidth(imageView);
									}
								}
							}
						});
					}
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Bitmap getFromFile(String url) {
		Bitmap bitmap = null;
		File file = new File(ADPATH);
		if (!file.exists()) {
			boolean create = file.mkdirs();
			Logger.d("create = " + create);
		} else {
			if (!file.isDirectory()) {
				file.delete();
				file.mkdir();
			}
		}
		File image = new File(ADPATH +"/"+ Md5Utils.md5(url)+".png");
		
		if(image.exists()){
			bitmap = BitmapFactory.decodeFile(image.getAbsolutePath());
		}
		
		if(null != bitmap){
			return bitmap;
		}
		return null;
	}

	//防止内存泄漏
	public void removeKey(ImageView view){
		mHashMap.remove(view);
	}

	private Bitmap getFromMap(String url) {
		return mCache.get(Md5Utils.md5(url));
	}
}
