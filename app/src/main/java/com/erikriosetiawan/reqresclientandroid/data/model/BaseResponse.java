package com.erikriosetiawan.reqresclientandroid.data.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse{

	@SerializedName("data")
	private Data data;

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"BaseResponse{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}