package com.shivasai.practice.folderOne.screenOne;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ScreenOneInterface {
    //https://jsonplaceholder.typicode.com/posts/1
    @GET("posts/{id}")
    Call<ModelScreenOne> ModelScreenOne(@Path("id") int id);
}
