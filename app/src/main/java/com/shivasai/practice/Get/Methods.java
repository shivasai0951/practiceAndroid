package com.shivasai.practice.Get;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {
    @GET("api/users?page=1")
    Call<Model> getData();
}
