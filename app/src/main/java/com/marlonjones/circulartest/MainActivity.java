package com.marlonjones.circulartest;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import static com.marlonjones.circulartest.R.id.text;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progBar;
    private TextView text;
    private Handler mHandler = new Handler();
    private int mProgressStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progBar = (ProgressBar) findViewById(R.id.progressBar);

        animateBar();
    }


    public void animateBar() {

        new Thread(new Runnable() {
            public void run() {
                final int percent = 0;
                while (mProgressStatus < 80) {
                    mProgressStatus += 1;
                    // Update progress bar to 80%. Change 80% to whatever value or resource needed.
                    mHandler.post(new Runnable() {
                        public void run() {
                            progBar.setProgress(mProgressStatus);
                        }
                    });
                    try {
                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

