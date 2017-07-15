package com.example.przem.animalsounds;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class RankingActivity extends Activity {

    public Integer score;
    public Button button_save;
    public EditText player_name;
    public ListView rank_list;
    public int[] img;
    public ImageView clean_data_button, refresh_button, icon;
    public DBhandler dbhandler = new DBhandler(this, null, null, 1);

    public int avatar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_layout);

        Bundle data = getIntent().getExtras();
        score = data.getInt("score");

        player_name = (EditText)findViewById(R.id.PlayerName);
        button_save = (Button)findViewById(R.id.button_save);
        rank_list = (ListView) findViewById(R.id.RankingList);
        clean_data_button = (ImageView) findViewById(R.id.clean_button);
        refresh_button = (ImageView) findViewById(R.id.refresh_button);
        ImageView logo = (ImageView) findViewById(R.id.Logo);
        icon = (ImageView) findViewById(R.id.PlayerIcon);
        draw_logo_colour(logo);
        img = make_list_of_images();
        icon.setImageResource(img[avatar]);

        clean_data_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup();
                    }
                }
        );

        icon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(avatar == 58){
                            avatar = 0;
                        }
                        avatar++;
                        icon.setImageResource(img[avatar]);
                    }
                }
        );

        if(score < 1){
            //clean entry from menu
            show_ranking();

        }
        else {
            //there was a game
        }
    }

    public void draw_logo_colour(ImageView logo){
        Random generator = new Random();
        logo.setColorFilter(Color.argb(255,generator.nextInt(100),generator.nextInt(100),generator.nextInt(100)));
    }

    public void save_score(View view){
        Ranking newposition = new Ranking(player_name.getText().toString(), score, img[avatar]);
        if(check_player_name(newposition.get_player_name())){
            dbhandler.add_players_score(newposition);
            show_ranking();
        }else{
            Toast.makeText(this, R.string.emptyname,Toast.LENGTH_SHORT).show();
        }
    }

    public void show_ranking(){
        ArrayList<Ranking> list;
       // ArrayList<String> rank = new ArrayList<>();
        //String position;

        player_name.setVisibility(View.GONE);
        button_save.setVisibility(View.GONE);
        icon.setVisibility(View.GONE);
        clean_data_button.setVisibility(View.VISIBLE);

        list = dbhandler.database_to_array();
        Collections.sort(list, new CustomComparator());

//        for(int i=0; i<list.size(); i++){
//            position = list.get(i).get_player_name().toString() + ":   " + String.valueOf(list.get(i).get_score()) + "pts";
//            rank.add(i, position );
//
//        }

        ListAdapter rank_list_adapter = new RankingArrayAdapter(this, list);
        rank_list.setAdapter(rank_list_adapter);
        rank_list.setVisibility(View.VISIBLE);


    }
// makes list of images - avatars
    public int[] make_list_of_images() {
        int[] img = new int[59];
        for (int i = 1; i < 60; i++) {
            String png = "avatar" + String.valueOf(i);
            img[i-1] = (getResources().getIdentifier(png, "drawable", getPackageName()));
        }
        return img;
    }

    public boolean check_player_name(String name){
        String pattern = "[a-zA-Z]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(name);
        return m.find();
    }

//POPUP window
    public void popup() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle(R.string.warning);
        adb.setMessage(R.string.is_it_ok_to_erase);
        adb.setPositiveButton(R.string.keep, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                show_ranking();
            }
        });
        adb.setNegativeButton(R.string.delete, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id){
              dbhandler.onUpgrade(dbhandler.getWritableDatabase(),1,1);
              show_ranking();
          }
        });
        adb.setIcon(R.drawable.owl);    // ikona popup
        adb.show();
    }
}
