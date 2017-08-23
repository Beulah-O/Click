package com.kings_studios.beulah_oluwafemi.click;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by beulah-oluwafemi on 8/19/17.
 */

public class Splash extends Activity {

    MediaPlayer intro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        intro = MediaPlayer.create(Splash.this, );
//        intro.start();

        setContentView(R.layout.splash);
        Thread timer = new Thread() {

            public void run() {

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Splash.this, DefaultClick.class);
                    startActivity(intent);
                    finish();
                }

            }

        };

        timer.start();
    }
}
