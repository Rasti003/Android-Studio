package com.example.przem.animalsounds;


public class Ranking{

    private int _score;
    private int _img;
    private String _player_name;

    public Ranking(String name, int score, int img){
        this._player_name = name;
        this._score = score;
        this._img = img;
    }

    public Ranking(){

    }

    public int get_score() {
        return _score;
    }

    public void set_score(int _score) {
        this._score = _score;
    }

    public int get_img() {
        return _img;
    }

    public void set_img(int _img) {
        this._img = _img;
    }

    public String get_player_name() {
        return _player_name;
    }

    public void set_player_name(String _player_name) {
        this._player_name = _player_name;
    }
}
