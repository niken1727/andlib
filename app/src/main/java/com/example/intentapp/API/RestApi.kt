package com.example.intentapp.API

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Niken on 7/23/2020.
 */
object RestApi {
    val apiServices: ApiServices

    init {

        val builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)

//        if (PreferenceHelper.containsAccessToken()) {
//            builder.addInterceptor(Interceptor() {
//                val original: Request = it.request()
//                val request: Request = original.newBuilder()
//                    .header("Authorization", "Bearer ${PreferenceHelper.getAccessToken()}")
//                    .method(original.method, original.body)
//                    .build()
//
//                it.proceed(request)
//            })
//
//        }

        val okHttpCLient = builder.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiUrl.BaseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpCLient)
            .build()

        apiServices = retrofit.create(ApiServices::class.java)
    }

    fun getApiService(): ApiServices = apiServices
}