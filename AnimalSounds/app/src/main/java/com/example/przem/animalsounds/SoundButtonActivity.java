package com.example.przem.animalsounds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;


public class SoundButtonActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_button);

        final Animation animation =new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(50);



        final Button StartGame = (Button)findViewById(R.id.button_ActiveGame);  //ustawienie lisnera na przycisk o zadanym id (slucha OnClick)

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Game is started " , Toast.LENGTH_SHORT).show(); //Wyswietlanie "POP-UP" z napisem

                    Intent intent = new Intent(getApplicationContext(), GameActivity.class); //PRZENOSZENIE NA INNE ACTIVITY: twozenie INTENS getApp..- aktualny kontekst aplikacje przycisk powrót tu przeniesie , Activity docelowe.class
                startActivity(intent);                       //Wywołanie przeniesienia

            }
        });


        final MediaPlayer CatPlayer = MediaPlayer.create(this, R.raw.cat);
        final Button playCat = (Button) this.findViewById(R.id.button_cat);

        playCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatPlayer.start();
                playCat.startAnimation(animation);



            }
        });


        final MediaPlayer DogPlayer = MediaPlayer.create(this, R.raw.dog);

       final Button playDog = (Button) this.findViewById(R.id.button_dog);

        playDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogPlayer.start();
                playDog.startAnimation(animation);

            }
        });

        final MediaPlayer CowPlayer = MediaPlayer.create(this, R.raw.cow);

        final Button playCow = (Button) this.findViewById(R.id.button_cow);

        playCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CowPlayer.start();
                playCow.startAnimation(animation);

            }
        });

        final MediaPlayer MonkeyPlayer = MediaPlayer.create(this, R.raw.monkey);

        final Button playMonkey = (Button) this.findViewById(R.id.button_monkey);

        playMonkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonkeyPlayer.start();
                playMonkey.startAnimation(animation);

            }
        });

        final MediaPlayer SheepPlayer = MediaPlayer.create(this, R.raw.sheep);

        final Button playSheep = (Button) this.findViewById(R.id.button_sheep);

        playSheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SheepPlayer.start();
                playSheep.startAnimation(animation);


            }
        });

        final MediaPlayer LionPlayer = MediaPlayer.create(this, R.raw.lion);
        final Button playLion = (Button) this.findViewById(R.id.button_lion);

        playLion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LionPlayer.start();
                playLion.startAnimation(animation);


            }
        });

        final MediaPlayer TigerPlayer = MediaPlayer.create(this, R.raw.tiger);
        final Button playTiger = (Button) this.findViewById(R.id.button_tiger);

        playTiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TigerPlayer.start();
                playTiger.startAnimation(animation);


            }
        });


        final MediaPlayer WolfPlayer = MediaPlayer.create(this, R.raw.wolf);
        final Button playWolf = (Button) this.findViewById(R.id.button_wolf);

        playWolf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WolfPlayer.start();
                playWolf.startAnimation(animation);


            }
        });



        final MediaPlayer PigPlayer = MediaPlayer.create(this, R.raw.pig);
        final Button playPig = (Button) this.findViewById(R.id.button_pig);

        playPig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PigPlayer.start();
                playPig.startAnimation(animation);


            }
        });



        final MediaPlayer ElephantPlayer = MediaPlayer.create(this, R.raw.elephant);
        final Button playElephant = (Button) this.findViewById(R.id.button_elephant);

        playElephant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElephantPlayer.start();
                playElephant.startAnimation(animation);


            }
        });




        final MediaPlayer EaglePlayer = MediaPlayer.create(this, R.raw.eagle);
        final Button playEagle = (Button) this.findViewById(R.id.button_eagle);

        playEagle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EaglePlayer.start();
                playEagle.startAnimation(animation);


            }
        });




        final Button playDuck = (Button) this.findViewById(R.id.button_duck);
        final MediaPlayer DuckPlayer = MediaPlayer.create(this, R.raw.duck);
        playDuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               
                DuckPlayer.start();
                playDuck.startAnimation(animation);


            }
        });

    }
}


