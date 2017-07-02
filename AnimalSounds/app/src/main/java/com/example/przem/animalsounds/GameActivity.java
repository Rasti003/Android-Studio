package com.example.przem.animalsounds;

import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import android.content.DialogInterface;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GameActivity extends AppCompatActivity {
    int myScore = 0;       // poczatkowal liczba pkt
    int Num_of_anim = 6; // liczba zwiezat !!! WYMAGA EWDYCJI PO DODANIU ZWIEZAT !!
    int random_animal = 0;
    int number_of_lives =5;
    private AdView mAdView;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);                                      // przygotowywanie przycisku pozycji w pliku XML z dopiskiem OnClick id skierowanie na .dog nie ma znaczenia wybierany jest  kazdy,  id ulega  zmianie podczas wykonywania animacji
        setContentView(R.layout.activity_game);
        b1 = (Button) findViewById(R.id.button_cat);

        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        popup();   // PO NACISNIECIU OK NSTEPUJE ROZPOCZECIE GRY POPRZEZ ODTWOZENIE DZWIEKU
        random_animal = RandomValue(Num_of_anim);       //przypisywanie wyllosowanego dzwieku pod zmienna
        DisplayScore(myScore,number_of_lives);       // wywołanie metody wyswietlania zdobytych punktów



    }


    //////////////////////////////////////////////////////////////////////////////////////////

    public void popup() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle(R.string.popup_game_title);
        adb.setMessage(R.string.popup_game_message);

        //final TextView tv=(TextView)findViewById(R.id.textView1);     // reakcia na przycisniecie przycyski w obieckie TextViec o Id textViev1

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                PlaySounds(random_animal);

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
            case 5:
                LionPlayer();
                break;


        }
    }


    public void DisplayScore(int myScore, int number_of_lives) {                             // deklaracje metody wyswietlania zdobytych punktów
        String message = "Score " + myScore;                    //  twozenie ciagu znakowego
        TextView Score = (TextView) findViewById(R.id.score);  // twozenie Score i odnajdywanie odpowiedniego pola tekstowego
        Score.setText(message);                                 //aktualizacja TextView

        String live_message =  "Live:  " + number_of_lives;
        TextView live = (TextView) findViewById(R.id.live);  //  funkcja wyswietlajace pozostałe zyca
        live.setText(live_message);
    }




    public int RandomValue(int Num_of_anim) {                   //  deklaracia medtody generowania jednego zwiezecia (losowej liczby) z przedziału liczby zwieząt
        Random generator = new Random();
        int r_value = generator.nextInt(Num_of_anim);
        return r_value;

    }




    public void DogPlayer() {                                                       // deklaracja metod dla  konkretnych dzwieków kazdy w osobnej metodzie
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
    public void LionPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.lion);
        Player.start();


    }



    public void AnswerDog(View v) {                                                     //reakcje na kokretne odpoiwedzi  sprawdzanie ich poprawnosci
        ButtonAnimation(0);

            if (random_animal == 0) {
                AddScore();
            } else {
               WrongAnwser();
            }
    }

    public void AnswerCow(View v) {
        ButtonAnimation(1);

            if (random_animal == 1) {
                AddScore();
            } else {
                WrongAnwser();
            }
    }

    public void AnswerMonkay(View v) {
        ButtonAnimation(2);

            if (random_animal == 2) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerCat(View v) {
        ButtonAnimation(3);
            if (random_animal == 3) {
                AddScore();
            } else {
                WrongAnwser();
            }
    }

    public void AnswerSheep(View v) {
        ButtonAnimation(4);
        if (random_animal == 4) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }
    public void AnswerLIon(View v) {
        ButtonAnimation(5);
        if (random_animal == 5) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }


    public void AddScore() {
        switch (random_animal) {

            case 0:
                Toast.makeText(getApplicationContext(), "YES!! This is a dog", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "YES!! This is a cow", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "YES!! This is a monkey", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "YES!! This is a cat", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(), "YES!! This is a sheep", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(getApplicationContext(), "YES!! This is a lion", Toast.LENGTH_SHORT).show();
                break;

        }
        myScore = myScore + 1;
        DisplayScore(myScore, number_of_lives);
        random_animal = RandomValue(Num_of_anim);
        PlaySounds(random_animal);
    }




    public void WrongAnwser() {
        Toast.makeText(getApplicationContext(), "The wrong answer", Toast.LENGTH_SHORT).show();
        number_of_lives = number_of_lives - 1;
        DisplayScore(myScore, number_of_lives);

        if (number_of_lives <= 0) {
            GameOverPopup();
            myScore =0;                          //zerowanie pkt w wypadku przegranej
            number_of_lives=5;                  // przywracanie domyslnej liczby zyc
       

        }
        MediaPlayer Player = MediaPlayer.create(this, R.raw.wrong);
        Player.start();
    }

    public void ButtonAnimation(int random_animal){                             // animacje po wcisnieciu porzycisku id jest zmieniane na konkredtne dla animowanego przycisku
       switch (random_animal){
           case 0:
               b1 = (Button) findViewById(R.id.button_dog);
               break;
           case 1:
               b1 = (Button) findViewById(R.id.button_cow);
               break;
           case 2:
               b1 = (Button) findViewById(R.id.button_monkey);
               break;
           case 3:
               b1 = (Button) findViewById(R.id.button_cat);
               break;
           case 4:
               b1 = (Button) findViewById(R.id.button_sheep);
               break;
           case 5:
               b1 = (Button) findViewById(R.id.button_lion);
               break;
       }




        final Animation animation =new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(500);                             //czas wykonywania animacji
        b1.startAnimation(animation);                           //startanimacji
    }




    public void GameOverPopup() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle(R.string.popup_gameover_title);
        adb.setMessage(R.string.popup_gameover_message);

        //final TextView tv=(TextView)findViewById(R.id.textView1);     // reakcia na przycisniecie przycyski w obieckie TextViec o Id textViev1

        adb.setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                PlaySounds(random_animal);

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

        adb.setIcon(R.drawable.black_cat);    // ikona popup
        adb.show();
    }

}


