package com.example.przem.animalsounds;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.content.DialogInterface;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;








public class GameActivity extends Activity {
    int myScore = 0;       // poczatkowal liczba pkt
    int Num_of_anim = 20; // liczba zwiezat !!! WYMAGA EWDYCJI PO DODANIU ZWIEZAT !!
    int random_animal = 0;
    int number_of_lives =3;
    private AdView mAdView;                                 //reklamy
    Button b1;                                          //zmienna przechowujaca id wcisnietego przyciusku
    ImageView HeartsImage;                              //zmienna przechowujace obrazy zyć

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // remove title
        setContentView(R.layout.activity_game);

        b1 = (Button) findViewById(R.id.button_cat);

        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        popup();   // PO NACISNIECIU OK NSTEPUJE ROZPOCZECIE GRY POPRZEZ ODTWOZENIE DZWIEKU
        random_animal = RandomValue(Num_of_anim);       //przypisywanie wyllosowanego dzwieku pod zmienna
        DisplayScore(myScore);       // wywołanie metody wyswietlania zdobytych punktów



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
            case 6:
                TigerPlayer();
                break;

            case 7:
                WolfPlayer();
                break;

            case 8:
                PigPlayer();
                break;

            case 9:
                ElephantPlayer();
                break;

            case 10:
                EaglePlayer();
                break;

            case 11:
                DuckPlayer();
                break;

            case 12:
                BearPlayer();
                break;

            case 13:
                BoarPlayer();
                break;

            case 14:
                AligatorPlayer();
                break;

            case 15:
                MousePlayer();
                break;

            case 16:
                BisonPlayer();
                break;

            case 17:
                CockPlayer();
                break;

            case 18:
                SquirrelPlayer();
                break;

            case 19:
                DeerPlayer();
                break;




        }
    }


    public void DisplayScore(int myScore) {                             // deklaracje metody wyswietlania zdobytych punktów
        String message = "Score " + myScore;                    //  twozenie ciagu znakowego
        TextView Score = (TextView) findViewById(R.id.score);  // twozenie Score i odnajdywanie odpowiedniego pola tekstowego
        Score.setText(message);                                 //aktualizacja TextView

        String live_message =  "Live:  " ;
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

    public void TigerPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.tiger);
        Player.start();


    }

    public void WolfPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.wolf);
        Player.start();


    }

    public void PigPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.pig);
        Player.start();


    }

    public void ElephantPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.elephant);
        Player.start();


    }

    public void EaglePlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.eagle);
        Player.start();


    }

    public void DuckPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.duck);
        Player.start();


    }

    public void BearPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.bear);
        Player.start();


    }
    public void AligatorPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.aligator);
        Player.start();


    }
    public void MousePlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.mouse1);
        Player.start();


    }
    public void BisonPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.bison);
        Player.start();


    }
    public void CockPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.cock);
        Player.start();


    }
    public void SquirrelPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.squirrel);
        Player.start();


    }
    public void DeerPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.deer);
        Player.start();


    }
    public void BoarPlayer() {
        MediaPlayer Player = MediaPlayer.create(this, R.raw.boar);
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

    public void AnswerTiger(View v) {
        ButtonAnimation(6);
        if (random_animal == 6) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }


    public void AnswerWolf(View v) {
        ButtonAnimation(7);
        if (random_animal == 7) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerPig(View v) {
        ButtonAnimation(8);
        if (random_animal == 8) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerElephant(View v) {
        ButtonAnimation(9);
        if (random_animal == 9) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerEagle(View v) {
        ButtonAnimation(10);
        if (random_animal == 10) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerDuck(View v) {
        ButtonAnimation(11);
        if (random_animal == 11) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerBear(View v) {
        ButtonAnimation(12);
        if (random_animal == 12) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }
    public void AnswerBoar(View v) {
        ButtonAnimation(13);
        if (random_animal == 13) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }
    public void AnswerAligator(View v) {
        ButtonAnimation(14);
        if (random_animal == 14) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerMouse(View v) {
        ButtonAnimation(15);
        if (random_animal == 15) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerBison(View v) {
        ButtonAnimation(16);
        if (random_animal == 16) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerCock(View v) {
        ButtonAnimation(17);
        if (random_animal == 17) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }

    public void AnswerSquirrel(View v) {
        ButtonAnimation(18);
        if (random_animal == 18) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }
    public void AnswerDeer(View v) {
        ButtonAnimation(19);
        if (random_animal == 19) {
            AddScore();
        } else {
            WrongAnwser();
        }
    }






    public  void Refresh (View v) {
        PlaySounds(random_animal);
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
            case 6:
                Toast.makeText(getApplicationContext(), "YES!! This is a tiger", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(getApplicationContext(), "YES!! This is a wolf", Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(getApplicationContext(), "YES!! This is a pig", Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(getApplicationContext(), "YES!! This is a elephant", Toast.LENGTH_SHORT).show();
                break;
            case 10:
                Toast.makeText(getApplicationContext(), "YES!! This is a eagle", Toast.LENGTH_SHORT).show();
                break;
            case 11:
                Toast.makeText(getApplicationContext(), "YES!! This is a duck", Toast.LENGTH_SHORT).show();
                break;
            case 12:
                Toast.makeText(getApplicationContext(), "YES!! This is a bear", Toast.LENGTH_SHORT).show();
                break;
            case 13:
                Toast.makeText(getApplicationContext(), "YES!! This is a boar", Toast.LENGTH_SHORT).show();
                break;
            case 14:
                Toast.makeText(getApplicationContext(), "YES!! This is a crocodile", Toast.LENGTH_SHORT).show();
                break;
            case 15:
                Toast.makeText(getApplicationContext(), "YES!! This is a mouse", Toast.LENGTH_SHORT).show();
                break;
            case 16:
                Toast.makeText(getApplicationContext(), "YES!! This is a bison", Toast.LENGTH_SHORT).show();
                break;
            case 17:
                Toast.makeText(getApplicationContext(), "YES!! This is a cock", Toast.LENGTH_SHORT).show();
                break;
            case 18:
                Toast.makeText(getApplicationContext(), "YES!! This is a squirrel", Toast.LENGTH_SHORT).show();
                break;
            case 19:
                Toast.makeText(getApplicationContext(), "YES!! This is a deer", Toast.LENGTH_SHORT).show();
                break;
        }
        myScore = myScore + 1;
        DisplayScore(myScore);
        random_animal = RandomValue(Num_of_anim);
        PlaySounds(random_animal);
    }




    public void WrongAnwser() {



        Toast.makeText(getApplicationContext(), "The wrong answer", Toast.LENGTH_SHORT).show();
        number_of_lives = number_of_lives - 1;
        DisplayScore(myScore);
                switch (number_of_lives){
                    case 2:
                        HeartsImage =(ImageView)findViewById(R.id.hearts3); // przypisanie pola imageView do zmiennej HeartsImage  - wyswietlanie zyć
                        //HeartsImage.setImageResource(R.drawable.lion);
                        HeartsImage.setImageAlpha(100);
                        break;
                    case 1:
                        HeartsImage =(ImageView)findViewById(R.id.hearts2); // przypisanie pola imageView do zmiennej HeartsImage  - wyswietlanie zyć
                       // HeartsImage.setImageResource(R.drawable.lion);
                        HeartsImage.setImageAlpha(100);
                        break;
                    case 0:
                        HeartsImage =(ImageView)findViewById(R.id.hearts1); // przypisanie pola imageView do zmiennej HeartsImage  - wyswietlanie zyć
                       // HeartsImage.setImageResource(R.drawable.lion);
                        HeartsImage.setImageAlpha(100);
                        break;
                }

        if (number_of_lives <= 0) {
            GameOverPopup();






            HeartsImage =(ImageView)findViewById(R.id.hearts3); //powtórne pokazywanie zyć
            HeartsImage.setImageAlpha(1000);
            HeartsImage =(ImageView)findViewById(R.id.hearts2);
            HeartsImage.setImageAlpha(1000);
            HeartsImage =(ImageView)findViewById(R.id.hearts1);
            HeartsImage.setImageAlpha(1000);
        }
        MediaPlayer Player = MediaPlayer.create(this, R.raw.wrong);
        Player.start();
    }




    public void ButtonAnimation(int random_animal){                             // animacje po wcisnieciu porzycisku id jest zmieniane na konkredtne dla animowanego przycisku
       switch (random_animal) {
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
           case 6:
               b1 = (Button) findViewById(R.id.button_tiger);
               break;

           case 7:
               b1 = (Button) findViewById(R.id.button_wolf);
               break;

           case 8:
               b1 = (Button) findViewById(R.id.button_pig);
               break;

           case 9:
               b1 = (Button) findViewById(R.id.button_elephant);
               break;

           case 10:
               b1 = (Button) findViewById(R.id.button_eagle);
               break;

           case 11:
               b1 = (Button) findViewById(R.id.button_duck);
               break;

           case 12:
               b1 = (Button) findViewById(R.id.button_bear);
               break;


           case 13:
               b1 = (Button) findViewById(R.id.button_boar);
               break;

           case 14:
               b1 = (Button) findViewById(R.id.button_crocodile);
               break;

           case 15:
               b1 = (Button) findViewById(R.id.button_mouse);
               break;


           case 16:
               b1 = (Button) findViewById(R.id.button_bison);
               break;





           case 17:
               b1 = (Button) findViewById(R.id.button_cock);
               break;


           case 18:
               b1 = (Button) findViewById(R.id.button_squirrel);
               break;

           case 19:
               b1 = (Button) findViewById(R.id.button_deer);
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
                myScore =0;                          //zerowanie pkt w wypadku przegranej
                number_of_lives=3;                  // przywracanie domyslnej liczby zyc
                //### akcja  po przyciśnieciu przycisku 1 / przykład zmiana TextViev
                //tv.setText("You have clicked ok");
            }
        });
        adb.setNegativeButton(R.string.save_score, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){

                Intent rank = new Intent(getApplicationContext(), RankingActivity.class);
                rank.putExtra("score", myScore); //add extras - score
                startActivity(rank);           //launch RankingActivity

            }});

        adb.setIcon(R.drawable.black_cat);    // ikona popup
        adb.show();
    }

}


