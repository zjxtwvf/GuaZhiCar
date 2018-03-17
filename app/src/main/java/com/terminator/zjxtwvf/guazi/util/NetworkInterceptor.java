package com.terminator.zjxtwvf.guazi.util;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/1/7.
 */

public class NetworkInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        boolean checked = true;
        if (response.code() == 200) {
            //这里是网络拦截器，可以做错误处理
            MediaType mediaType = response.body().contentType();
            //当调用此方法java.lang.IllegalStateException: closed，原因为OkHttp请求回调中response.body().string()只能有效调用一次
            //String content = response.body().string();
            byte[] data = response.body().bytes();
            if (GZIPUtils.isGzip(response.headers())) {
                //请求头显示有gzip，需要解压
                data = GZIPUtils.uncompress(data);
            }

            if (!checked) {
                return null;
            } else {
                //创建一个新的responseBody，返回进行处理
                Response re1 = response.newBuilder()
                        .body(ResponseBody.create(mediaType, data))
                        .build();
                String newData = re1.body().string();
                String newData1 = newData;
                String newData2 = newData;
                if(newData.contains("font-size")){
                    newData1 = newData.replace("font-size","font_size");
                }

                if(newData.contains("padding-left")){
                    newData2 = newData1.replace("padding-left","padding_left");
                    newData = newData2;
                }
                String newData3 = newData;
                if(newData.contains("bottom_tags")){
                    newData3 = newData.replace("\"bottom_tags\":\"\"","\"bottom_tags\":{}");
                }

                Response re = response.newBuilder()
                        .body(ResponseBody.create(mediaType, newData3))
                        .build();
                System.out.println("gzip ----------->");
                return re;
            }
        } else {
            return response;
        }
    }
}
