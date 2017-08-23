package com.kings_studios.beulah_oluwafemi.click;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

//import java.util.Timer;

public class DefaultClick extends AppCompatActivity {

    Button numbers, click;
    ProgressBar pBar;
    TextView display;
    int counter;
    int pBarCounter = 100;
//    CountDownTimer timer;

    private boolean pinable(int number) {
        {
            return number % 7 == 0 || number % 10 == 7;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_click);

        numbers = (Button) findViewById(R.id.numbers);
        click = (Button) findViewById(R.id.click);
        display = (TextView) findViewById(R.id.tV);
        pBar = (ProgressBar) findViewById(R.id.progressBar);
        pBar.setProgress(0);
        pBar.setMax(100);


        if (pBarSetter() < 1) {
            display.setText(R.string.youLose);
            counter = 0;
        }

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pBarSetter();

                if (pinable(counter + 1)) {
                    display.setText(R.string.youLose);
                    counter = 0;
                    pBarCounter = pBarSetter();
                    pBar.setProgress(pBarCounter);

                } else {
                    counter++;
                    display.setText(String.valueOf(counter));
                    numbers.setText(String.valueOf(counter + 1));
                    pBarCounter = pBarSetter();
                    pBar.setProgress(pBarSetter());
                }

            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pBarSetter();

                if (!pinable(counter + 1)) {
                    display.setText(R.string.youLose);
                    counter = 0;
                    pBarCounter = 100;
                    pBar.setProgress(pBarCounter);
                } else {
                    counter++;
                    display.setText(String.valueOf(counter));
                    numbers.setText(String.valueOf(counter + 1));
                    pBarCounter = 100;
                    pBar.setProgress(pBarCounter);
                }

            }
        });
    }

    public int pBarSetter() {
        pBarCounter = pBarCounter-1;
        pBar.setProgress(pBarCounter);

        return pBarCounter;
    }
}
