package com.example.przem.animalsounds;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBhandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ranking.db";
    public static final String TABLE_RANKING = "ranking";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_IMG = "img";


    public DBhandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_RANKING + "(" +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SCORE + " INTEGER, " +
                COLUMN_IMG + " INTEGER " +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RANKING +";");
        onCreate(db);

    }

    public void add_players_score(Ranking ranking){

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, ranking.get_player_name());
        values.put(COLUMN_SCORE, ranking.get_score());
        values.put(COLUMN_IMG, ranking.get_img());

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_RANKING, null, values);
        //db.insert(TABLE_RANKING, COLUMN_SCORE, values);
        db.close();

    }

    public void delete_player(String player){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_RANKING + " WHERE " + COLUMN_NAME + "=\"" + player + "\";");
    }

    public ArrayList<Ranking> database_to_array(){
        ArrayList<Ranking> players = new ArrayList<Ranking>();
        String DBout = " ";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_RANKING + " WHERE 1;";

        //create Cursor - database pointer
        Cursor cursor = db.rawQuery(query, null);
        // move cursor at the begining
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            if(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) != null){
                //DBout = cursor.getString(cursor.getColumnIndex("name"));
                players.add(new Ranking(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)), cursor.getInt(cursor.getColumnIndex(COLUMN_SCORE)), cursor.getInt(cursor.getColumnIndex(COLUMN_IMG))));
                cursor.moveToNext();
            }
        }
        db.close();
        return players;
    }
}
