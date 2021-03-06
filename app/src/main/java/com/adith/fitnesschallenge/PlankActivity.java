package com.adith.fitnesschallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by adith bharadwaj on 7/11/2017.
 */

public class PlankActivity extends AppCompatActivity {

    private Button start;
    private  Button stop;

    private TextView timer;

    CountDownTimer mtimer;

    private TextView btnvideo;

    public int count = 0;

    public String noOfPlanks;

    public  Button submit;

    public EditText mplanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plankactivity);

        start = (Button) findViewById(R.id.start);
        timer = (TextView)findViewById(R.id.timer);

        stop = (Button) findViewById(R.id.stop);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mtimer.cancel();
                start.setClickable(true);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mtimer = new CountDownTimer(200000, 1000) {

                    public void onTick(long millis) {

                        timer.setText(String.valueOf(count));
                        count++;

                        start.setClickable(false);

                    }

                    public void onFinish() {

                    }



                }.start();
            }

        });

        btnvideo = (TextView) findViewById(R.id.play);

        btnvideo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=TvxNkmjdhMM")));
                Log.i("Video", "Video Playing....");

            }
        });

        btnvideo = (TextView) findViewById(R.id.play);

        btnvideo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_M2Etme-tfE")));
                Log.i("Video", "Video Playing....");

            }
        });

        submit = (Button) findViewById(R.id.submitchallenges);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mplanks = (EditText) findViewById(R.id.crunchestext);

                String ed_text = mplanks.getText().toString().trim();

                if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)
                {
                    //EditText is empty

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "please enter the details", Toast.LENGTH_LONG);
                    toast.show();

                }

                else {
                    noOfPlanks = mplanks.getText().toString().trim();

                    Context context = getApplicationContext();

                    Toast toast = Toast.makeText(context, "Successfully submitted. checkout Results or Goals", Toast.LENGTH_LONG);
                    toast.show();

                    SharedPreferences prefs = getSharedPreferences("results", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("Planks", noOfPlanks);
                    editor.commit();


                    //Shared Preferences

                }

            }
        });

    }

    // method to get no of planks


}

