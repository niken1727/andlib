package com.example.test1.API;

import android.content.Context;
import android.database.Observable;

import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Niken on 7/22/2020.
 */
public class RestApi {
    Context context;
    ApiServices apiServices;
    private static OkHttpClient client;
    private static Retrofit retrofit;

    public RestApi(Context context) {
        this.context = context;
    }

    public void init(){
         retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.Initiate)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client(context))
                .build();

         apiServices = retrofit.create(ApiServices.class);
    }

    private OkHttpClient client(Context context) {
        if(client == null){
            client = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();
        }
        return client;
    }

}
