package com.shehabsalah.jokeapp.paid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.shehabsalah.displaymyjoke.DisplayJokeActivity;
import com.shehabsalah.jokeapp.EndpointsAsyncTask;
import com.shehabsalah.jokeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.joke_button)
    Button joke_button;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(true);

        joke_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointsAsyncTask() {
                    @Override
                    public void onPreExecute() {
                        pDialog.setMessage(getResources().getString(R.string.Loading_message));
                        showDialog();
                    }

                    @Override
                    public void onPostExecute(String result) {
                        hideDialog();
                        if (result!=null && !result.isEmpty()){
                            displayJokes(result);
                        }
                    }
                }.execute();

            }
        });

    }
    private void displayJokes(String joke){
        if (joke!=null && !joke.isEmpty()){
            Intent intent = new Intent(this, DisplayJokeActivity.class);
            intent.putExtra(getResources().getString(R.string.intent_name),joke);
            startActivity(intent);
        }
    }

    private void showDialog() {
        if (pDialog !=null && !pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog !=null && pDialog.isShowing())
            pDialog.dismiss();
    }
}

