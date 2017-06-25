package com.example.przem.animalsounds;

import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Random;
import android.content.DialogInterface;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    //  int myScore =0;       // poczatkowal liczba pkt
    int Num_of_anim = 5; // liczba zwiezat !!! WYMAGA EWDYCJI PO DODANIU ZWIEZAT !!
    int random_animal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        popup();
        random_animal = RandomValue(Num_of_anim);
        DisplayScore(random_animal);       // wywołanie metody wyswietlania zdobytych punktów
        PlaySounds(random_animal);


        setContentView(R.layout.activity_game);


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

    public int RandomValue(int Num_of_anim) {                   //  deklaracia medtody generowania jednego zwiezecia (losowej liczby) z przedziału liczby zwieząt
        Random generator = new Random();
        int r_value = generator.nextInt(Num_of_anim);
        return r_value;

    }

    public void DogPlayer() {                                                       // deklaracja metod dla  konkretnych dziwkeów kazdy w osobnej metodzie
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


    public void popup() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle(R.string.popup_game_title);
        adb.setMessage(R.string.popup_game_message);

        //final TextView tv=(TextView)findViewById(R.id.textView1);     // reakcia na przycisniecie przycyski w obieckie TextViec o Id textViev1

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //### akcja  po przyciśnieciu przycisku 1 / przykład zmiana TextViev
                //tv.setText("You have clicked ok");
            }
        });
             // ########Przycisk Cancel #########
            // adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            // {
            //  public void onClick(DialogInterface dialog, int id)
            // ###akcja  po przyciśnieciu przycisku 2 / przykład zmiana TextViev
            //tv.setText("You have clicked Cancel");
            //   dialog.cancel();
            //}});

            adb.setIcon(R.drawable.owl);    // ikona popup
            adb.show();
    }
}


