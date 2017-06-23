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

        final MediaPlayer CowPlayer = MediaPlayer.create(this, R.raw.cow);

        Button playCow = (Button) this.findViewById(R.id.button_cow);

        playCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CowPlayer.start();


            }
        });

        final MediaPlayer MonkeyPlayer = MediaPlayer.create(this, R.raw.monkey);

        Button playMonkey = (Button) this.findViewById(R.id.button_monkey);

        playMonkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonkeyPlayer.start();


            }
        });

        final MediaPlayer SheepPlayer = MediaPlayer.create(this, R.raw.sheep);

        Button playSheep = (Button) this.findViewById(R.id.button_sheep);

        playSheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SheepPlayer.start();


            }
        });





        }

}


