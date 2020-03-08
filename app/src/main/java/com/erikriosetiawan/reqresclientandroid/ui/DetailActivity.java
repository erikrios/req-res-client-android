package com.erikriosetiawan.reqresclientandroid.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.erikriosetiawan.reqresclientandroid.R;
import com.erikriosetiawan.reqresclientandroid.data.remote.ApiInterface;

public class DetailActivity extends AppCompatActivity {

    public static final String EXT_ID = "DetailsActivity.Id";

    private Context context = this;
    private TextView txtName;
    private ApiInterface apiInterface;
    private ProgressDialog progressDialog;

    public static void start(Context context, int userId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXT_ID, userId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
