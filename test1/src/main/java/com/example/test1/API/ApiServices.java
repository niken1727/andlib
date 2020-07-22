package com.example.test1.API;

import android.database.Observable;

import com.google.gson.JsonObject;

import retrofit2.http.POST;

/**
 * Created by Niken on 7/22/2020.
 */
public interface ApiServices {
    @POST(ApiUrl.Initiate)
        public Observable<JsonObject> initiate();
}
