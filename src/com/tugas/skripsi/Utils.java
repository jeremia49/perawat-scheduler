package com.tugas.skripsi;

import java.util.ArrayList;
import java.util.Collections;

public class Utils {

    public static Populasi getBestOne(ArrayList<Populasi> pop){
        pop = (ArrayList<Populasi>) pop.clone();
        Collections.sort(pop);
        return pop.get(pop.size()-1);
    }

    public static Populasi[] getBestTwo(ArrayList<Populasi> pop){
        pop = (ArrayList<Populasi>) pop.clone();
        Populasi[] result = new Populasi[2];
        Collections.sort(pop);
        result[0] = pop.get(pop.size()-1);

        pop.remove(pop.size()-1);
        result[1] = pop.get(pop.size()-1);
        return result;
    }

}
