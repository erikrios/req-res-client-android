package com.erikriosetiawan.reqresclientandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.erikriosetiawan.reqresclientandroid.R;
import com.erikriosetiawan.reqresclientandroid.data.model.BaseResponse;
import com.erikriosetiawan.reqresclientandroid.data.remote.ApiClient;
import com.erikriosetiawan.reqresclientandroid.data.remote.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    public static final String EXT_ID = "DetailsActivity.Id";

    private Context context = this;
    private TextView txtName;
    private ApiInterface apiInterface;
    private ProgressDialog progressDialog;

    private int selectedUserId;

    public static void start(Context context, int userId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXT_ID, userId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        selectedUserId = getIntent().getIntExtra(EXT_ID, 0);
        getDataUsers();
    }

    private void showProgress(boolean show) {
        if (show) {
            progressDialog = new ProgressDialog(DetailActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    private void getDataUsers() {
        if (apiInterface == null) {
            apiInterface = ApiClient.getClient().create(ApiInterface.class);
        }

        showProgress(true);

        Call<BaseResponse> call = apiInterface.getUser(selectedUserId);

        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {

            }
        });
    }
}