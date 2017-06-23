package com.example.przem.animalsounds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class SoundButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_button);

        final MediaPlayer CatPlayer = MediaPlayer.create(this, R.raw.cat);

        Button playCat = (Button) this.findViewById(R.id.button_cat);

        playCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatPlayer.start();


            }
        });


        final MediaPlayer DogPlayer = MediaPlayer.create(this, R.raw.dog);

        Button playDog = (Button) this.findViewById(R.id.button_dog);

        playDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogPlayer.start();


            }
        });

    }




    }


