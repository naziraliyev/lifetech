package com.example.lifetech.networks;

import com.example.lifetech.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("/mobile/user/login")
    public Call<UserResponse> sendLogin(@Query("identity") String login,@Query("password") String password);
}
