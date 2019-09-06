package com.enes_08.reclerviewdatabinding.networking;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();

        private static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        public static <S> S cteateService(Class<S> serviceClass) {

            return retrofit.create(serviceClass);
        }


}
