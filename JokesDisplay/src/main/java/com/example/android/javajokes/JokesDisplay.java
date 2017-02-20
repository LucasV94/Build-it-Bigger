package com.example.android.javajokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by LucasVasquez on 2/19/17.
 */

public class JokesDisplay extends AppCompatActivity {

    public static final String EXTRA_JOKE = "joke";


//    public static Intent getJokeDisplayActivityIntent(Context context, String joke) {
//        Intent intent = new Intent(context, JokeDisplayActivity.class);
//        intent.putExtra(EXTRA_JOKE, joke);
//        return intent;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        TextView tv = (TextView) findViewById(R.id.joke_text_view);
        String joke = getIntent().getExtras().getString(EXTRA_JOKE);

        tv.setText(joke);
    }
}


