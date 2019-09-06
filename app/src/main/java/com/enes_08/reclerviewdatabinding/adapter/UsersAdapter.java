package com.enes_08.reclerviewdatabinding.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.enes_08.reclerviewdatabinding.R;
import com.enes_08.reclerviewdatabinding.databinding.ItemRowUserBinding;
import com.enes_08.reclerviewdatabinding.model.Result;
import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<Result> userList;
    private LayoutInflater layoutInflater;
    private usersAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ItemRowUserBinding  binding;

        public MyViewHolder(final ItemRowUserBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


    public UsersAdapter(List<Result> userList, usersAdapterListener listener) {
        this.userList = userList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemRowUserBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_row_user, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.binding.setUser(userList.get(position));

        holder.binding.cvRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onuserClicked(userList.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface usersAdapterListener {
        void onuserClicked(Result user);
    }

    public void setEmployeeList(List<Result> employees) {
        this.userList = employees;
        notifyDataSetChanged();
    }
}
