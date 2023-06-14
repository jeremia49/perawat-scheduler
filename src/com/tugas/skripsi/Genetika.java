package com.tugas.skripsi;

import java.util.Arrays;

public class Genetika {

    public String[][] pembangkitanPopulasi(int iterasi, int populasi, int jumlahperawat, int jumlahshift,
                                           int jumlahperawatpershift) {

        //kebutuhan perawat tiap hari = jumlah shift * butuh tiap tiap shift = 3 * 3 = 9
        //kebutuhan perawat dalam 1 bulan = 9 * 30 = 270 gen

        String chromosome[][] = new String[iterasi][populasi];
        int[][] gen = new int[30 * jumlahshift][jumlahperawatpershift];
        int[] perawat = new int[jumlahperawat];
        for (int ulang = 0; ulang < populasi; ulang++) {
            chromosome[0][ulang] = "";
            for (int k = 0; k < jumlahperawat; k++) {
                perawat[k] = 0;
            }
            for (int i = 0; i < 30 * jumlahshift; i++) {
                for (int j = 0; j < jumlahperawatpershift; j++) {
                    int random;
                    boolean cek;
                    do {
                        random = (int) (Math.random() * jumlahperawat + 1);
                        if (perawat[random - 1] < (int) Math.ceil(30 * jumlahshift * jumlahperawatpershift / jumlahperawat) + 1) {
                            cek = false;
                        } else {
                            cek = true;
                        }
                    } while (cek);
                    perawat[random - 1]++;
                    gen[i][j] = random;
                    chromosome[0][ulang] += gen[i][j];
                    chromosome[0][ulang] += " ";
                }
            }
        }
        return chromosome;
    }


    public static int pinalti1(String a, int jumlahshift, int jumlahperawatpershift) {
        //antar shift
        int gen[][] = new int[30 * jumlahshift][jumlahperawatpershift];
        String[] kromosom = a.split(" ");
        int cek[];
        cek = new int[kromosom.length];
        int pinalti1 = 0;
        int pinaltia = 0;
        int pinaltib = 0;
        for (int i = 0; i < kromosom.length; i++) {
            cek[i] = Integer.parseInt(kromosom[i]);
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
        int k = 0;
        int l = 0;
        int gen2[][][] = new int[30][jumlahshift][5];
        for (int i = 0; i < 30 * jumlahshift; i++) {
            if (l == jumlahshift) {
                k++;
                l = 0;
            }
            for (int j = 0; j < jumlahperawatpershift; j++) {
                gen2[k][l][j + 1] = gen[i][j];
            }
            l++;
        }
        Arrays.sort(gen2[0][0]);
        for (k = 0; k < 30; k++) {
            for (int j = 1; j < 5; j++) {
                if (Arrays.binarySearch(gen2[k][0],
                        gen2[k][2][j]) > 0) {

                } else {
                }
            }
        }

        pinalti1 = pinaltia + pinaltib;
        return pinalti1;
    }

    public static int pinalti2(String a, int jumlahshift, int jumlahperawatpershift, int jumlahperawat) {
        int gen[][] = new int[30*jumlahshift][jumlahperawatpershift];
        int gen1[][] = new int[30*jumlahshift][jumlahperawatpershift];
        int perawat[] = new int[jumlahperawat];
        int jmlpinalti[] = new int[jumlahperawat];
        int maxshiftmalam = (int) Math.ceil(23/jumlahshift);

        String[] kromosom = a.split(" ");
        int cek[] = new int[kromosom.length];
        int pinalti = 0;

        for (int i = 0; i < kromosom.length; i++) {
            cek[i] = Integer.parseInt(kromosom[i]);
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
            for (int j = 0; j < jumlahperawatpershift; j++) {
                for (int k = 0; k < jumlahperawat; k++) {
                    int h = k + 1;
                    if (h == gen1[i][j]) {
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

    public static int pinalti3(String a, int jumlahshift, int jumlahperawatpershift){
        int gen[][] = new int[30*jumlahshift][jumlahperawatpershift];
        int gen1[][] = new int[30*jumlahshift][jumlahperawatpershift];
        String[] kromosom = a.split(" ");
        int cek[] = new int[kromosom.length];
        int pinalti3=0;
        for(int i = 0;i < kromosom.length;i++){
            cek[i] = Integer.parseInt(kromosom[i]);
        }
        int cek1=0;
        for(int i=0;i<30*jumlahshift;i++){
            for(int j=0;j<jumlahperawatpershift;j++){
                gen[i][j]=cek[cek1];
                gen1[i][j]=gen[i][j];
                cek1++;
            }
        }for(int i=0;i<30*jumlahshift;i++){
            for(int j=0;j<jumlahperawatpershift;j++){
                for(int k=j+1;k<jumlahperawatpershift;k++){
                    if(gen[i][j]==gen1[i][k]) {
                        pinalti3++;
                    }
                }
            }
        }
        return pinalti3;
    }

    public static int pinalti4(String a, int jumlahshift, int jumlahperawatpershift, String []idP, String []tgl){
        String idPer[]=new String[idP.length];
        int temp_id[] = new int[idP.length];
        int temp_tgl[] = new int[tgl.length];
        int temp_pinalti4[]= new int[idP.length];
        int pinalti4=0;

        for(int i=0; i<idPer.length; i++){
            int pinalti=0;
            temp_id[i]=Integer.parseInt(idP[i]);
            temp_tgl[i]=Integer.parseInt(tgl[i]);
            int no=temp_id[i];
            int tanggal=temp_tgl[i];
            int gen[][] = new int[30][jumlahshift*jumlahperawatpershift];
            String[] kromosom = a.split(" ");
            int cek[] = new int[kromosom.length];
            for(int j = 0;j < kromosom.length;j++){
                cek[j] = Integer.parseInt(kromosom[j]);
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
        int[] anak3 = new int[30*jumlahshift*jumlahperawatpershift];
        int[] temp = new int[30*jumlahshift*jumlahperawatpershift];
        for (int i = 0; i < pisah.length; i++) {
            if (i < anak3.length) {
                anak3[i] = Integer.parseInt(pisah[i]);
                temp[i] = Integer.parseInt(pisah[i]);
            }
        }
        anak3[titik1] = temp[titik2];
        anak3[titik2] = temp[titik1];
        for (int i = 0; i < pisah.length; i++) {
            if (i < anak3.length) {
                anak += anak3[i];
                anak += " ";
            }
        }
        return anak;
    }


    }
