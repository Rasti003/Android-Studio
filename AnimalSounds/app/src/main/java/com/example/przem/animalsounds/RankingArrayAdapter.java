package com.example.przem.animalsounds;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

class RankingArrayAdapter extends ArrayAdapter<Ranking>{

    public RankingArrayAdapter(@NonNull Context context, ArrayList<Ranking> players) {
        super(context, R.layout.list_row_ranking, players);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater rankingInflater = LayoutInflater.from(getContext());
        View customView = rankingInflater.inflate(R.layout.list_row_ranking, parent, false);

        String name = getItem(position).get_player_name();
        int score = getItem(position).get_score();
        int img_resource = getItem(position).get_img();

        ImageView playericon = (ImageView) customView.findViewById(R.id.PlayerIcon);
        TextView playername = (TextView) customView.findViewById(R.id.PlayerName);
        TextView playerscore = (TextView) customView.findViewById(R.id.PlayerScore);

        try{
            playericon.setImageResource(img_resource);
        }catch (Exception e){
            playericon.setImageResource(R.drawable.avatar1);
        }
        playername.setText(name);
        playerscore.setText(String.valueOf(score));
        return customView;
    }

}
