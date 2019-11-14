package com.example.alexr.ideamanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.alexr.ideamanager.services.MessageService;
import com.example.alexr.ideamanager.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


        final TextView message = (TextView) findViewById(R.id.message);

        //default static text replaced with a call to web service.
         /* message.setText("This is hardcoded, but thanks for visiting the app!  Our next hackathon is scheduled for the end of " +
                "Q3.  We hope to see you there, be sure to add your ideas to the app!");*/


        //Create an instance of MessageService, which will act as the implementation of the interface that maps the RESTful endPoints.
        MessageService taskService = ServiceBuilder.buildService(MessageService.class);
        Call<String> call = taskService.getMessages("http://192.168.0.15:7000/messages");  //messageService instance used to call the RESTful webservice methods.

        //add reference used to call RESTful methods to an asynchronous queue managed by Retrofit.
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> request, Response<String> response) {
                //called to handle Response from webService.
                message.setText(response.body()); //set the message on the Ui.
            }

            @Override
            public void onFailure(Call<String> request, Throwable t) {
                message.setText("Request Failed");

            }
        });

    }

    public void GetStarted(View view) {
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivity(intent);
    }
}
