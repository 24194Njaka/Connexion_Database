package com.app;

import java.io.InputStream; // Pour lire le fichier de configuration depuis le classpath
import java.io.IOException; // Pour gérer les erreurs de lecture de fichier
import java.sql.Connection;  // Pour représenter une connexion à la base de données
import java.sql.DriverManager; // Pour obtenir la connexion JDBC
import java.sql.SQLException;  // Pour gérer les erreurs SQL
import java.util.Properties;  // Pour lire les propriétés depuis un fichier

public class Database {

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        // changement des information du fichier interieur
        try (InputStream fis = Database.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (fis == null) {
                throw new IOException("Fichier db.properties introuvable dans resources !");
            }
            props.load(fis);
        }


        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }




    public static void main(String[] args) {
        try(Connection connection = getConnection()) {
            System.out.println("Connexion réussie !");
        } catch (SQLException | IOException e) {
            System.out.println(" Erreur de connexion : " + e.getMessage());
        }finally {

        }
        System.out.println("Hello");
    }
}
