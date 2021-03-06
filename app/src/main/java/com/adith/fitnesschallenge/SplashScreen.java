package com.adith.fitnesschallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class SplashScreen extends AppCompatActivity {

    private TextView splash;
    private ImageView iv;
    private TextView challenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        iv = (ImageView)findViewById(R.id.iv);
        challenge = (TextView) findViewById(R.id.challenge);



        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.challenge);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.mytransition);

        iv.startAnimation(anim);

        challenge.startAnimation(anim2);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}