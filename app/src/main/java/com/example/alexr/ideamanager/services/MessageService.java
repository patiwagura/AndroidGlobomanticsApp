package com.example.alexr.ideamanager.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MessageService {
    //@GET("messages")
    //Call<String> getMessages();

    //Specifying an alternative server url. @Url annotation is used to override the BASE_URL In the serviceBuilder.
    @GET
    Call<String> getMessages(@Url String altUrl);
}
