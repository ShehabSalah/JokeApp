package com.shehabsalah.jokeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.shehabsalah.displaymyjoke.DisplayJokeActivity;
import com.shehabsalah.jokeapp.EndpointsAsyncTask;
import com.shehabsalah.jokeapp.R;
import com.shehabsalah.jokeapp.SimpleIdlingResource;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    // The Idling Resource which will be null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public SimpleIdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }



    @BindView(R.id.joke_button)
    Button joke_button;
    private ProgressDialog pDialog;
    private boolean isItFree = false;
    private InterstitialAd mInterstitialAd;
    String joke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(true);

        if (findViewById(R.id.adView) != null){
            isItFree = true;
            AdView adView = (AdView)findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();

            adView.loadAd(adRequest);
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());


            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    // Load the next interstitial.
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    displayJokes();
                }

            });

        }

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
                            joke = result;
                            if (isItFree){
                                if (mInterstitialAd.isLoaded()) {
                                    mInterstitialAd.show();
                                } else {
                                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                                }
                            }else{
                                displayJokes();
                            }


                        }
                    }
                }.execute();

            }
        });
        // Get the IdlingResource instance
        getIdlingResource();

    }
    private void displayJokes(){
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
