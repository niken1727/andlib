package com.example.intentapp.API

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServices {

    @GET(ApiUrl.getList)
    fun getList(): Observable<JsonObject>

    @POST(ApiUrl.Initiate)
    fun initiate(@Body req: JsonObject): Observable<JsonObject>
}