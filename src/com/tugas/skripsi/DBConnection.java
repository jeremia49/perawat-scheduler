package com.tugas.skripsi;

import java.sql.*;
import java.util.HashMap;

public class DBConnection {

    private final static String URL = "jdbc:mysql://localhost:3306/db_perawat?zeroDateTimeBehavior=CONVERT_TO_NULL ";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private static Connection conn;
    private static Statement stmt;

    public static Statement getStatement() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            return stmt;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static HashMap<String,String> getAllPerawat() throws Exception {
        HashMap<String,String> perawat = new HashMap<String, String>();
        ResultSet rs = getStatement().executeQuery("select * from perawat");
        while (rs.next()) {
            perawat.put(rs.getString("id_perawat"), rs.getString("nama_perawat"));
        }
        rs.close();
        return perawat;
    }


}
