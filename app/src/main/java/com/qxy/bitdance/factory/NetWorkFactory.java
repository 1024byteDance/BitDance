package com.qxy.bitdance.factory;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//网络请求工厂类
public class NetWorkFactory {

    private static OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor((message) -> {
            // 监听Http请求日志
        });
        //这行必须加 不然默认不打印
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(interceptor)
                .build();
    }

    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://open.douyin.com")
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
