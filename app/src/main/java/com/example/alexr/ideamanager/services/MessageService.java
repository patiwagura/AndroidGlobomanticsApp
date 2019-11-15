package com.example.alexr.ideamanager.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MessageService {
    //@GET("messages")
    //Call<String> getMessages();

    //Specify an alternative URL to fetch data from another external server.
    //Retrofit @Url annotation overrides the BASE_URL define in ServiceBuilder e.g getMessage(@Url String altUrl)
    @GET
    Call<String> getMessages(@Url String altUrl);  //Retrofit will override the BASE_URL
}
