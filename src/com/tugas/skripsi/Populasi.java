package com.tugas.skripsi;

public class Populasi implements Comparable<Populasi>{
    public String gen;
    public double fitness;
    public int jumlahperawat;
    public int jumlahshift;
    public int jumlahperawatpershift;
    public String[] idPerawatLibur;
    public String[] tanggalLibur;

    public String id;
    public String parent1;
    public String parent2;

    public boolean isCrossOver;
    public boolean isMutation;

    public void refreshFitness(){
        int pinalti1 = Genetika.pinalti1(this.gen, this.jumlahshift,this.jumlahperawatpershift);
        int pinalti2 = Genetika.pinalti2(this.gen, this.jumlahshift,this.jumlahperawatpershift, this.jumlahperawat);
        int pinalti3 = Genetika.pinalti3(this.gen, this.jumlahshift,this.jumlahperawatpershift);
        int pinalti4 = Genetika.pinalti4(this.gen, this.jumlahshift,this.jumlahperawatpershift, this.idPerawatLibur, this.tanggalLibur);

        this.fitness =  Genetika.fitness(pinalti1,pinalti2,pinalti3,pinalti4);
    }

    public Populasi(String gen, int jumlahshift, int jumlahperawat, int jumlahperawatpershift, String[] idPerawatLibur, String[] tanggalLibur){
        this.gen = gen;
        this.jumlahshift = jumlahshift;
        this.jumlahperawat = jumlahperawat;
        this.jumlahperawatpershift = jumlahperawatpershift;
        this.idPerawatLibur = idPerawatLibur;
        this.tanggalLibur = tanggalLibur;

        refreshFitness();
    }

    public Populasi(String gen, int jumlahshift, int jumlahperawat, int jumlahperawatpershift, String[] idPerawatLibur, String[] tanggalLibur, int id){
        this(gen,jumlahshift, jumlahperawat, jumlahperawatpershift, idPerawatLibur, tanggalLibur);
        this.id = String.valueOf(id);

        refreshFitness();
    }

    public Populasi(String gen, int jumlahshift,int jumlahperawat, int jumlahperawatpershift, String[] idPerawatLibur, String[] tanggalLibur, int id, int p1){
        this(gen,jumlahshift, jumlahperawat, jumlahperawatpershift, idPerawatLibur, tanggalLibur, id);
        this.parent1 = String.valueOf(p1);
        this.isMutation = true;

        refreshFitness();
    }

    public Populasi(String gen, int jumlahshift, int jumlahperawat, int jumlahperawatpershift, String[] idPerawatLibur, String[] tanggalLibur, int id, int p1, int p2){
        this(gen,jumlahshift, jumlahperawat, jumlahperawatpershift, idPerawatLibur, tanggalLibur, id);
        this.parent1 = String.valueOf(p1);
        this.parent2 = String.valueOf(p2);
        this.isCrossOver = true;

        refreshFitness();
    }



    @Override
    public int compareTo(Populasi o) {
        this.refreshFitness();
        o.refreshFitness();
        if(this.fitness == o.fitness){
            return 0;
        }else if (this.fitness > o.fitness) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Gen : " + String.format("%5.5s", gen) + "... [f="+fitness+"]";
    }
}
