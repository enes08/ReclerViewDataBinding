package com.enes_08.reclerviewdatabinding.networking;

import com.enes_08.reclerviewdatabinding.model.UsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

   //
    @GET("api/")
    Call<UsersResponse> getNewsList(@Query("results") String  userCount);


}
