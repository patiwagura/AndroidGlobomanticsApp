package com.example.alexr.ideamanager.services;

import com.example.alexr.ideamanager.models.Idea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IdeaService {
    //annotation @GET("ideas") => matches a path in RESTful webservide path e.g 192.168.0.15:9000/ideas
    @GET("ideas")
    Call<List<Idea>> getIdeas();
}
