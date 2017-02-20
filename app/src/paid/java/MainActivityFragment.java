package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.javajokes.JokesDisplay;




public class MainActivityFragment extends Fragment implements OnJokeReceivedListener {

    private String mJoke;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) root.findViewById(R.id.joke_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchJoke();
            }
        });

        return root;
    }

    @Override
    public void onReceived(String joke) {
        mJoke = joke;
        startJokeActivity();
    }

    private void startJokeActivity() {
        Intent intent = new Intent(getActivity(), JokesDisplay.class);
        intent.putExtra(JokesDisplay.EXTRA_JOKE, mJoke);
        startActivity(intent);
    }

    public void fetchJoke() {
        new EndpointsAsyncTask().execute(this);
    }
}
