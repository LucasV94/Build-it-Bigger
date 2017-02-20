package com.udacity.gradle.builditbigger;


import android.os.AsyncTask;

import com.example.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


/**
 * Created by LucasVasquez on 2/19/17.
 */

public class EndpointsAsyncTask extends AsyncTask<OnJokeReceivedListener, Void, String> {

    private static MyApi myApiService = null;
    private OnJokeReceivedListener mListener;


    @Override
    protected String doInBackground(OnJokeReceivedListener... params) {

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-158922.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        mListener = params[0];

        try {
            return myApiService.sayJoke("joke").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        mListener.onReceived(result);
    }
}