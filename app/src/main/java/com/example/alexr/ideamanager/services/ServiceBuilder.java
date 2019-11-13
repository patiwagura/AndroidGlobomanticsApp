package com.example.alexr.ideamanager.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    //http://192.168.0.15:9000/ideas/id  => Localhost IP-address.
    private static final String URL = "http://192.168.0.15:9000/";  //define Base_URL.

    //create instance of the logger
    private static HttpLoggingInterceptor logger = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY); //allows logging BODY & Headers.

    //create OkHttp Client and register the interceptor to the okHttpClient. Interceptor is a low level function of okHttp.
    private static OkHttpClient.Builder okHttp = new OkHttpClient.Builder().addInterceptor(logger);


    //Using Retrofit.Builder to set properties e.g URL and Gson-Converter.
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build());  //Tell retrofit to use our custom okHttpClient which has an interceptor.


    //create an instance of retrofit from builder.
    private static Retrofit retrofit = builder.build();


    //helper message to build service.
    //public static <TypeParameter> returnType methodName(class<Type> param)
    public static <S> S buildService(Class<S> serviceType) {
        return retrofit.create(serviceType);
    }


}
