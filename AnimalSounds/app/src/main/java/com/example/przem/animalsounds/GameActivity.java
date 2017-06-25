package com.example.przem.animalsounds;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;


public class GameActivity extends AppCompatActivity {
    //  int myScore =0;       // poczatkowal liczba pkt
    int Num_of_anim = 5; // liczba zwiezat !!! WYMAGA EWDYCJI PO DODANIU ZWIEZAT !!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        DisplayScore(RandomValue(Num_of_anim));       // wywołanie metody wyswietlania zdobytych punktów
        PlaySounds(RandomValue(Num_of_anim));


    }


    //////////////////////////////////////////////////////////////////////////////////////////
    public void PlaySounds(int RandomNumer) {                         // instrukacia switch dokonujaca wyboru aktualnie odtwazanego dzwieku w zaleznosci od wylosowanej liczby
        switch (RandomNumer) {

            case 0:
                DogPlayer();
                break;
            case 1:
                CowPlayer();
                break;
            case 2:
                MonkeyPlayer();
                break;
            case 3:
                CatPlayer();
                break;
            case 4:
                SheepPlayer();
                break;

        }
    }


    public void DisplayScore(int myScore) {                             // deklaracje metody wyswietlania zdobytych punktów
        String message = "Score " + myScore;                    //  twozenie ciagu znakowego
        TextView Score = (TextView) findViewById(R.id.score);  // twozenie Score i odnajdywanie odpowiedniego pola tekstowego
        Score.setText(message);                                 //aktualizacja TextView
    }

    public int RandomValue(int Num_of_anim) {                   //  deklaracia medtody generowania jednego zwiezecia (losowej liczby) z przedziału liczby zwiezat
        Random generator = new Random();
        int r_value = generator.nextInt(Num_of_anim);
        return r_value;

    }

    public void DogPlayer() {                                                       // deklaracie metod dla  konkretnych dziwkeów kazdy w osobnej metodzie
        MediaPlayer Player = MediaPlayer.create(this, R.raw.dog);
        Player.start();
    }

    public void CowPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.cow);
        Player.start();
    }

    public void MonkeyPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.monkey);
        Player.start();
    }

    public void SheepPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.sheep);
        Player.start();
    }

    public void CatPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.cat);
        Player.start();


    }


}


