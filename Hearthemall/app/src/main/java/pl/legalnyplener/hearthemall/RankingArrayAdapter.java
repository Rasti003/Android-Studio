package pl.legalnyplener.hearthemall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

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
