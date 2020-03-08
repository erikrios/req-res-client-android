package com.erikriosetiawan.reqresclientandroid.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.erikriosetiawan.reqresclientandroid.R;
import com.erikriosetiawan.reqresclientandroid.data.model.UserResponse;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private final Context context;
    private final List<UserResponse> userResponseList;

    public MainListAdapter(Context context, List<UserResponse> userResponseList) {
        this.context = context;
        this.userResponseList = userResponseList;
    }

    @NonNull
    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainListAdapter.ViewHolder holder, int position) {
        final UserResponse userData = userResponseList.get(position);

        holder.txtName.setText(userData.getFirstName() + " " + userData.getLastName());
        holder.txtEmail.setText(userData.getEmail());

        Glide.with(context).load(userData.getAvatar()).into(holder.imgUser);
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUser;
        TextView txtName;
        TextView txtEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.img_user);
            txtName = itemView.findViewById(R.id.txt_name);
            txtEmail = itemView.findViewById(R.id.txt_email);
        }
    }
}
