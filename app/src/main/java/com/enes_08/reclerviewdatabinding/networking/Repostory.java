package com.enes_08.reclerviewdatabinding.networking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.enes_08.reclerviewdatabinding.model.UsersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repostory {

    private static Repostory newsRepository;

    public static Repostory getInstance(){
        if (newsRepository == null){
            newsRepository = new Repostory();
        }
        return newsRepository;
    }

    private Api mApi;

    public Repostory(){
        mApi = RetrofitService.cteateService(Api.class);



    }

    public MutableLiveData<UsersResponse> getNews(String userCount){

        final MutableLiveData<UsersResponse> newsData = new MutableLiveData<>();

        mApi.getNewsList(userCount).enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call,
                                   Response<UsersResponse> response) {

                Object j=response.body().getResults();


                    newsData.setValue(response.body());

            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {

                Log.e("Error",t.getMessage());
                newsData.setValue(null);
            }
        });
        return newsData;
    }


}
