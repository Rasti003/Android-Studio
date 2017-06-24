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
        animation.setDuration(1000);



        final Button StartGame = (Button)findViewById(R.id.button_ActiveGame);  //ustawienie lisnera na przycisk o zadanym id (slucha OnClick)

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Game is started " , Toast.LENGTH_SHORT).show(); //Wyswietlanie "POP-UP" z napisem  dlaszy ci

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






    }
}


