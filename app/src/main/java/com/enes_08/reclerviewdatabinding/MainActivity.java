package com.enes_08.reclerviewdatabinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.enes_08.reclerviewdatabinding.adapter.UsersAdapter;
import com.enes_08.reclerviewdatabinding.databinding.ActivityMainBinding;
import com.enes_08.reclerviewdatabinding.model.Result;
import com.enes_08.reclerviewdatabinding.model.UsersResponse;
import com.enes_08.reclerviewdatabinding.networking.Repostory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsersAdapter.usersAdapterListener{

    private MutableLiveData<UsersResponse> mutableLiveData;
    private Repostory mRepository;


    private UsersAdapter mAdapter;
    private RecyclerView recyclerView;
    private ActivityMainBinding binding;
    private Result user;
    List<Result>userResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mRepository=Repostory.getInstance();
       userResult=new ArrayList<>();

        initReclerView();




    }

    private void initReclerView() {
        recyclerView = binding.rvStudents;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mAdapter = new UsersAdapter(userResult, this);
        recyclerView.setAdapter(mAdapter);

        initData();



    }


    private void initData() {



        mRepository.getNews("5").observe(this, usersResponse-> {

                if(usersResponse!=null){
                   userResult =  usersResponse.getResults();
                    mAdapter.setEmployeeList(userResult);

                }
                Toast.makeText(getApplicationContext(),userResult.size()+"",Toast.LENGTH_LONG).show();



        });

}


    @Override
    public void onuserClicked(Result user) {
        Toast.makeText(getApplicationContext(),user.getName().getFirst()+"-"+user.getName().getLast(),Toast.LENGTH_LONG).show();

    }
}
