package com.adith.fitnesschallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private Button btnFullscreenAd;
    private InterstitialAd minterstitial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("5236510CBD1C2A152524347315E8CD0A")
                .build();
        mAdView.loadAd(adRequest);


        /** btnFullscreenAd = (Button) findViewById(R.id.btn_fullscreen_ad);

         btnFullscreenAd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        startActivity(new Intent(Choices.this, SecondActivity.class));
        }
        });

         */

        TextView challenges = (TextView) findViewById(R.id.challenges);


        challenges.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent challenges = new Intent(MainActivity.this, com.adith.fitnesschallenge.challenges.class);
                startActivity(challenges);

            }
        });

        /**  minterstitial = new InterstitialAd(this);
         minterstitial.setAdUnitId("ca-app-pub-9549050735651802/9232744386");
         AdRequest request = new AdRequest.Builder()
         .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
         .build();
         minterstitial.loadAd(request);

         */

        TextView goals = (TextView) findViewById(R.id.goals);

        goals.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent challenges = new Intent(MainActivity.this, Goals.class);
                startActivity(challenges);

                Context context = getApplicationContext();

                Toast toast = Toast.makeText(context, "Finish challenges first! ", Toast.LENGTH_SHORT);
                toast.show();


            }
        });

        TextView bmi = (TextView) findViewById(R.id.bmi);

        bmi.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent bmi = new Intent(MainActivity.this, Choices.class);
                startActivity(bmi);
            }
        });

        /**  TextView pb = (TextView) findViewById(R.id.pb);

         pb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent challenges = new Intent(Choices.this, personalbest.class);
        startActivity(challenges);
        }
        });
         */

        TextView result = (TextView) findViewById(R.id.results);


        result.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent challenges = new Intent(MainActivity.this, Result.class);
                startActivity(challenges);

                Context context = getApplicationContext();

                Toast toast = Toast.makeText(context, "Finish challenges first! ", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


    }


    public class CustomTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ((TextView) view).setTextColor(0xFFFFFFFF); // white
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    ((TextView) view).setTextColor(Color.parseColor("#4a4a4a")); // lightblack
                    break;
            }
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mmenu = getMenuInflater();
        mmenu.inflate(R.menu.menu_activity, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings:

                SharedPreferences preferences = getSharedPreferences("results", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();

                Context context = getApplicationContext();

                Toast toast = Toast.makeText(context, "The Data has been cleared. you can now enter new data", Toast.LENGTH_LONG);
                toast.show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
