package com.tugas.skripsi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Output {

    JFrame frame;

    Output(ArrayList<Populasi> populasiawal, ArrayList<Populasi> crossovermutasi, ArrayList<Populasi> populasiakhir){
        frame = new JFrame("Progress");
        frame.setSize(500,700);
        frame.setResizable(true);
        frame.setLayout(new GridLayout(3,1));
        
        
        {
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            JLabel l = new JLabel("Tabel Populasi Awal", SwingConstants.CENTER);
            p.add(l, BorderLayout.PAGE_START);
            p.add(tablePopulasiAwal(populasiawal), BorderLayout.CENTER);
            frame.add(p);
        }

        {
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            JLabel l = new JLabel("Tabel Hasil Crossover dan Mutasi", SwingConstants.CENTER);
            p.add(l, BorderLayout.PAGE_START);
            p.add(tabelCrossoverDanMutasi(crossovermutasi), BorderLayout.CENTER);
            frame.add(p);
        }

        {
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            JLabel l = new JLabel("Hasil Seleksi", SwingConstants.CENTER);
            p.add(l,BorderLayout.PAGE_START);
            p.add(tabelPopulasiAkhir(populasiakhir), BorderLayout.CENTER);
            frame.add(p);
        }
        
//        JScrollPane scrollPane = new JScrollPane(p);
//        frame.add(scrollPane);
//        frame.add(p);
//        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public void destroy(){
        frame.dispose();
    }
    private JScrollPane tablePopulasiAwal(ArrayList<Populasi> populasiawal){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Individu");
        tableModel.addColumn("Kromosom");
        tableModel.addColumn("Fitness");

        int i = 0;
        for(Populasi row : populasiawal){
            i++;
            Object[] a = new Object[3];
            a[0] = i;
            a[1] = row.gen;
            a[2] = row.fitness;
            tableModel.addRow(a);
        }

        JTable table = new JTable(tableModel);
        return new JScrollPane(table);
    }

    private JScrollPane tabelPopulasiAkhir(ArrayList<Populasi> populasiakhir){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Individu");
        tableModel.addColumn("Kromosom");
        tableModel.addColumn("Fitness");

        int i = 0;
        for(Populasi row : populasiakhir){
            i++;
            Object[] a = new Object[3];
            a[0] = i;
            a[1] = row.gen;
            a[2] = row.fitness;
            tableModel.addRow(a);
        }

        JTable table = new JTable(tableModel);
        return new JScrollPane(table);
    }

    private JScrollPane tabelCrossoverDanMutasi(ArrayList<Populasi> crossoverDanMutasi){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Individu");
        tableModel.addColumn("Parent Asal");
        tableModel.addColumn("Kromosom");
        tableModel.addColumn("Fitness");

        for(Populasi row : crossoverDanMutasi){
            Object[] a = new Object[4];
            a[0] = row.id;
            if(row.isCrossOver){
                a[1] = row.parent1 + " " + row.parent2;
            }else if(row.isMutation){
                a[1] = row.parent1;
            }
            a[2] = row.gen;
            a[3] = row.fitness;
            tableModel.addRow(a);
        }

        JTable table = new JTable(tableModel);
        return new JScrollPane(table);
    }

}
