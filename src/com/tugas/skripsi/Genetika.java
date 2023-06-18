package com.tugas.skripsi;

import java.util.Arrays;
import java.util.HashMap;

public class Genetika {

    public String[][] pembangkitanPopulasi(HashMap<String,String> dataperawat,int iterasi, int populasi, int jumlahperawat) {
        //pagi (3 shift) , siang (2 shift + 1 d), malam (2 shift)
        //kebutuhan perawat tiap hari = 7
        //kebutuhan perawat dalam 1 bulan = 7 * 30 = 210 gen
        int totalperawat1shift = 3; // w/ padding 
        int totalperawat1hari = (3 + 2 + 2);
        int totalperawat1bulan = 30*totalperawat1hari;
        int totalshift = 3;
        
        Object[] perawatsArray = dataperawat.keySet().toArray();

        String chromosome[][] = new String[iterasi][populasi];
        String[][] gen = new String[totalperawat1bulan][totalperawat1shift];
        int[] jumlahkerja_perawat = new int[jumlahperawat];
        for (int ulang = 0; ulang < populasi; ulang++) {
            chromosome[0][ulang] = "";
            for (int k = 0; k < jumlahperawat; k++) {
                jumlahkerja_perawat[k] = 0;
            }
            for (int i = 0; i < 30; i++) { //loop harian
                //shift pagi
                for (int j = 0; j < totalperawat1shift; j++) {
                    int random;
                    boolean cek;
                    do {
                        random = (int) (Math.random() * jumlahperawat + 1);
                        if (jumlahkerja_perawat[random - 1] < (int) Math.ceil(30 * totalshift * totalperawat1shift / jumlahperawat) + 1) {
                            cek = false;
                        } else {
                            cek = true;
                        }
                    } while (cek);
                    jumlahkerja_perawat[random - 1]++;
                    gen[i][j] = (String) perawatsArray[random - 1];
                    chromosome[0][ulang] += gen[i][j];
                    chromosome[0][ulang] += " ";
                }

                //shift siang
                for (int j = 0; j < totalperawat1shift - 1; j++) {
                    int random;
                    boolean cek;
                    do {
                        random = (int) (Math.random() * jumlahperawat + 1);
                        if (jumlahkerja_perawat[random - 1] < (int) Math.ceil(30 * totalshift * totalperawat1shift / jumlahperawat) + 1) {
                            cek = false;
                        } else {
                            cek = true;
                        }
                    } while (cek);
                    jumlahkerja_perawat[random - 1]++;
                    gen[i][j] = (String)   perawatsArray[random - 1];
                    chromosome[0][ulang] += gen[i][j];
                    chromosome[0][ulang] += " ";
                }
                chromosome[0][ulang] += "_ ";

                //shift sore
                for (int j = 0; j < totalperawat1shift - 1; j++) {
                    int random;
                    boolean cek;
                    do {
                        random = (int) (Math.random() * jumlahperawat + 1);
                        if (jumlahkerja_perawat[random - 1] < (int) Math.ceil(30 * totalshift * totalperawat1shift / jumlahperawat) + 1) {
                            cek = false;
                        } else {
                            cek = true;
                        }
                    } while (cek);
                    jumlahkerja_perawat[random - 1]++;
                    gen[i][j] =  (String)  perawatsArray[random - 1];
                    chromosome[0][ulang] += gen[i][j];
                    chromosome[0][ulang] += " ";
                }
                chromosome[0][ulang] += "_ ";
            }
        }
        return chromosome;
    }


    public static int pinalti1(String a) {
        int jumlahshift = 3;
        int jumlahperawatpershift = 3;
        //antar shift
        String gen[][] = new String[30 * jumlahshift][jumlahperawatpershift];
        String[] kromosom = a.split(" ");
        
        String cek[] =  new String[kromosom.length];
        int pinalti1 = 0;
        int pinaltia = 0;
        int pinaltib = 0;
        for (int i = 0; i < kromosom.length; i++) {
            if(kromosom[i].equals("_")){
                cek[i] = "";
            }else{
                cek[i] = kromosom[i];
            }
        }                 

        int cek1 = 0;
        for (int i = 0; i < 30 * jumlahshift; i++) {
            for (int j = 0; j < jumlahperawatpershift; j++) {
                gen[i][j] = cek[cek1];
                cek1++;
            }
        }
        for (int i = 1; i < 30 * jumlahshift; i++) {
            Arrays.sort(gen[i]);
            for (int j = 0; j < jumlahperawatpershift; j++) {
                if (Arrays.binarySearch(gen[i], gen[i - 1][j]) > 0) {
                    pinaltia = pinaltia + 1;
                }
            }
        }
        // int k = 0;
        // int l = 0;
        // String gen2[][][] = new String[30][jumlahshift][5];
        // for (int i = 0; i < 30 * jumlahshift; i++) {
        //     if (l == jumlahshift) {
        //         k++;
        //         l = 0;
        //     }
        //     for (int j = 0; j < jumlahperawatpershift; j++) {
        //         gen2[k][l][j + 1] = gen[i][j];
        //     }
        //     l++;
        // }
        // Arrays.sort(gen2[0][0]);
        // for (k = 0; k < 30; k++) {
        //     for (int j = 1; j < 5; j++) {
        //         if (Arrays.binarySearch(gen2[k][0],
        //                 gen2[k][2][j]) > 0) {

        //         } else {
        //         }
        //     }
        // }

        pinalti1 = pinaltia + pinaltib;
        return pinalti1;
    }

    public static int pinalti2(String a, HashMap<String,String> dataperawat,int jumlahperawat) {
        int jumlahshift = 3;
        int jumlahperawatpershift = 3;

        String gen[][] = new String[30*jumlahshift][jumlahperawatpershift];
        String gen1[][] = new String[30*jumlahshift][jumlahperawatpershift];
        Object[] perawatsArray = dataperawat.keySet().toArray();
        int perawat[] = new int[jumlahperawat];
        int jmlpinalti[] = new int[jumlahperawat];
        int maxshiftmalam = (int) Math.ceil(23/jumlahshift);

        String[] kromosom = a.split(" ");
        String cek[] = new String[kromosom.length];
        int pinalti = 0;

        for (int i = 0; i < kromosom.length; i++) {
            if(kromosom[i].equals("_")){
                cek[i] = "";
            }else{
                cek[i] = kromosom[i];
            };
        }
        int cek1 = 0;
        for (int i = 0; i < 30*jumlahshift; i++) {
            for (int j = 0; j < jumlahperawatpershift; j++) {
                gen[i][j] = cek[cek1];
                cek1++;
            }
        }
        int cek2 = 0;
        for (int i = 2; i < 30*jumlahshift; i = i + 3) {
            for (int j = 0; j < jumlahperawatpershift; j++) {
                gen1[i][j] = gen[i][j];
                cek2++;
            }
        }
        for (int i = 2; i < 30*jumlahshift; i = i + 3) {
            for (int j = 0; j < jumlahperawatpershift - 1 ; j++) {  //shift malam
                for (int k = 0; k < jumlahperawat; k++) {
                    if((String)perawatsArray[k] == gen1[i][j]){
                        perawat[k]++;
                    }
                }
            }
        }
        for (int k = 0; k < jumlahperawat; k++) {
            if (perawat[k] > maxshiftmalam) {
                jmlpinalti[k] = perawat[k] - maxshiftmalam;
            } else {
                jmlpinalti[k] = 0;
            }
            pinalti = pinalti + jmlpinalti[k];
        }
        return pinalti;
    }

    public static int pinalti3(String a){
        int jumlahshift = 3;
        int jumlahperawatpershift = 3;

        String gen[][] = new String[30*jumlahshift][jumlahperawatpershift];
        String gen1[][] = new String[30*jumlahshift][jumlahperawatpershift];
        String[] kromosom = a.split(" ");
        String cek[] = new String[kromosom.length];
        int pinalti3=0;
        for(int i = 0;i < kromosom.length;i++){
            if(kromosom[i].equals("_")){
                cek[i] = "";
            }else{
                cek[i] = kromosom[i];
            };
        }
        int cek1=0;
        int state = 0;
        for(int i=0;i<30*jumlahshift;i++){
            if(state == 0){ //shift pagi
                for(int j=0;j<jumlahperawatpershift;j++){
                    gen[i][j]=cek[cek1];
                    gen1[i][j]=gen[i][j];
                    cek1++;
                }
                state += 1;
            }else if(state == 1){
                for(int j=0;j<jumlahperawatpershift-1;j++){
                    gen[i][j]=cek[cek1];
                    gen1[i][j]=gen[i][j];
                    cek1++;
                }
                state += 1;
            }else if(state == 2){
                for(int j=0;j<jumlahperawatpershift-1;j++){
                    gen[i][j]=cek[cek1];
                    gen1[i][j]=gen[i][j];
                    cek1++;
                }
                state = 0;
            }
  
        }

        state = 0;
        for(int i=0;i<30*jumlahshift;i++){
            if(state == 0){ //shift pagi
                for(int j=0;j<jumlahperawatpershift;j++){
                    for(int k=j+1;k<jumlahperawatpershift;k++){
                        if(gen[i][j]==gen1[i][k]) {
                            pinalti3++;
                        }
                    }
                }
                state += 1;
            }else if(state == 1){
                for(int j=0;j<jumlahperawatpershift-1;j++){
                    for(int k=j+1;k<jumlahperawatpershift-1;k++){
                        if(gen[i][j]==gen1[i][k]) {
                            pinalti3++;
                        }
                    }
                }
                state += 1;
            }else if(state == 2){
                for(int j=0;j<jumlahperawatpershift-1;j++){
                    for(int k=j+1;k<jumlahperawatpershift-1;k++){
                        if(gen[i][j]==gen1[i][k]) {
                            pinalti3++;
                        }
                    }
                }
                state = 0;
            }

        }
        return pinalti3;
    }

    public static int pinalti4(String a, String []idP, String []tgl){
        int jumlahshift = 3;
        int jumlahperawatpershift = 3;

        String idPer[]=new String[idP.length];
        String temp_id[] = new String[idP.length];
        int temp_tgl[] = new int[tgl.length];
        int temp_pinalti4[]= new int[idP.length];
        int pinalti4=0;

        for(int i=0; i<idPer.length; i++){
            int pinalti=0;
            temp_id[i]=idP[i];
            temp_tgl[i]=Integer.parseInt(tgl[i]);
            String no=temp_id[i];
            int tanggal=temp_tgl[i];
            String gen[][] = new String[30][jumlahshift*jumlahperawatpershift];
            String[] kromosom = a.split(" ");
            String cek[] = new String[kromosom.length];
            for(int j = 0;j < kromosom.length;j++){
                if(kromosom[i].equals("_")){
                    cek[i] = "";
                }else{
                    cek[i] = kromosom[i];
                };
            }
            int cek1=0;
            for(int j=0;j<30;j++){
                for(int k=0;k<jumlahshift*jumlahperawatpershift;k++){
                    gen[j][k]=cek[cek1];
                    cek1++;
                }
            }
            for(int j=0;j<jumlahshift*jumlahperawatpershift;j++){
                if(no == gen[tanggal-1][j]) {
                    pinalti = 1;
                }
            }
            temp_pinalti4[i]=pinalti;
            pinalti4=pinalti4 + temp_pinalti4[i];
        }
        return pinalti4;
    }

    public static double fitness(int pinalti1, int pinalti2, int pinalti3,
                          int pinalti4){

        int fitness= (5*pinalti1+5*pinalti2+20*pinalti3+20*pinalti4)+1;
        double fitnes1 = 100/ (double) fitness;

        int angkaSignifikan = 4;
        double temp = Math.pow(10, angkaSignifikan);
        return (double) Math.round(fitnes1*temp)/temp;
    }

    public static String[] crossover(int titik, String p1, String p2) {
        String[] pisah1 = p1.split(" ");
        String[] pisah2 = p2.split(" ");
        String anak1 = "";
        String anak2 = "";
        String[] anaks = new String[2];

        for (int i = 0; i < titik; i++) {
            anak1 += pisah1[i];
            anak1 += " ";
            anak2 += pisah2[i];
            anak2 += " ";
        }
        for (int i = titik; i < pisah1.length; i++) {
            anak1 += pisah2[i];
            anak1 += " ";
            anak2 += pisah1[i];
            anak2 += " ";
        }
        anaks[0] = anak1;
        anaks[1] = anak2;
        return anaks;
    }

    public static String mutasi(int titik1, int titik2, String p, int jumlahshift, int jumlahperawatpershift) {
        String anak = "";
        String[] pisah = p.split(" ");
        String[] anak3 = new String[30*jumlahshift*jumlahperawatpershift];
        String[] temp = new String[30*jumlahshift*jumlahperawatpershift];
        for (int i = 0; i < pisah.length; i++) {
            if (i < anak3.length) {
                anak3[i] = pisah[i];
                temp[i] = pisah[i];
            }
        }
        if(!anak3[titik1].equals("_") || !temp[titik1].equals("_") ){ //skip jika salah satu berisi _
            anak3[titik1] = temp[titik2];
            anak3[titik2] = temp[titik1];
        }
        for (int i = 0; i < pisah.length; i++) {
            if (i < anak3.length) {
                anak += anak3[i];
                anak += " ";
            }
        }
        return anak;
    }


    }
