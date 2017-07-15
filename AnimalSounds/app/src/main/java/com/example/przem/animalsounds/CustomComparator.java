package com.example.przem.animalsounds;


import java.util.Comparator;

public class CustomComparator implements Comparator<Ranking>{
    @Override
    public int compare(Ranking o1, Ranking o2) {
        int r = ((Integer) o1.get_score()).compareTo((Integer)o2.get_score());
        return -r;
    }
}
