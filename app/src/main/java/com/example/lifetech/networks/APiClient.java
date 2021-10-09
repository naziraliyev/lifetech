package com.example.lifetech.networks;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APiClient {

    public static String BASE_URL = "http://admin.life-tech.uz";
    public static Retrofit retrofit=null;

    public static Retrofit getClient(){
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder().connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
