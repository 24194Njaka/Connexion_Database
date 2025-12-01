package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/hei_herinjak";
    private static final String USER = "postgres";
    private static final String PASSWORD = "njaka033";



    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
            connection.close();
        } catch (SQLException e) {
            System.out.println(" Erreur de connexion : " + e.getMessage());
        }finally {

        }
        System.out.println("Hello");
    }
}
