package com.example.alexr.ideamanager.services;

import com.example.alexr.ideamanager.models.Idea;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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

    //create a new Idea that is saved on the webservice.
    @POST("ideas")
    //@POST("resource_URL")
    Call<Idea> createIdea(@Body Idea newIdea);   //@Body tells Retrofit to serialize the java Object to Json and attach it to Request body.

    //Update an existing Idea, using @Field and @FormUrlEncoded annotations.
    //@PUT points to RESTful webService PATH e.g http://192.168.0.15/ideas/8
    @FormUrlEncoded
    @PUT("ideas/{id}")
    Call<Idea> updateIdea(
            @Path("id") int id,
            @Field("name") String name,
            @Field("description") String desc,
            @Field("status") String status,
            @Field("owner") String owner
    );

}
