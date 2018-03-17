package com.terminator.zjxtwvf.guazi.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.terminator.zjxtwvf.guazi.di.components.DaggerNetComponent;
import com.terminator.zjxtwvf.guazi.di.components.NetComponent;
import com.terminator.zjxtwvf.guazi.di.modules.NetModule;

public class MyApplication extends Application{
	private static Context context;
	private static int mainThreadId;
	private NetComponent netComponent;

	public static MyApplication getContext() {
		return (MyApplication)context;
	}

	public static Handler getHandler() {
		return handler;
	}

	private static Handler handler;
	
	@Override
	public void onCreate() {
		context = getApplicationContext();
		handler = new Handler();
		mainThreadId =  android.os.Process.myTid();
		netComponent = DaggerNetComponent.builder()
				.netModule(new NetModule())
				.build();
		super.onCreate();
	}

	public static int getMainThreadId() {
		return mainThreadId;
	}

	public NetComponent getNetComponent() {
		return netComponent;
	}

	public MyApplication getInstance()
	{
		return this;
	}
}
