package com.terminator.zjxtwvf.guazi.di.modules;

import com.terminator.zjxtwvf.guazi.BuildConfig;
import com.terminator.zjxtwvf.guazi.model.api.ApiService;
import com.terminator.zjxtwvf.guazi.util.NetworkInterceptor;

import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/11/27.
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient()
    {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG?HttpLoggingInterceptor.Level.BODY:HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(new NetworkInterceptor())
                .build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit =new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.guazi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public  ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
