package com.example.alexr.ideamanager.services;

import com.example.alexr.ideamanager.models.Idea;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface IdeaService {
    //annotation @GET("ideas") => matches a path in RESTful webservide path e.g 192.168.0.15:9000/ideas

    //Return all ideas in a List.
    //@GET("ideas")
    //Call<List<Idea>> getIdeas();

    //Filter results using owner. Return only ideas created by specified owner e.g owner=Jim
    //@GET("ideas")
    //Call<List<Idea>> getIdeas(@Query("owner") String owner);

    //Using QueryMap to pass multiple query parameters to the web service.
    @GET("ideas")
    Call<List<Idea>> getIdeas(@QueryMap HashMap<String, String> filters);

    //Get a single Idea with specified id.
    @GET("ideas/{id}")
    Call<Idea> getIdea(@Path("id") int id);

}
