package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDAO {
    private Connection connection;

    // Constructeur
    public ConnexionDAO() {
        connection=getConnection();

    }

    // Méthode pour obtenir une connexion à la base de données
    public Connection getConnection() {
        if (connection == null) {
            try {
                // Informations de connexion à la base de données
                String url = "jdbc:mysql://mysql-bddtestizspe.alwaysdata.net/bddtestizspe_aic";
                String username = "386765";
                String password = "bdtestIzSPetT1eSt!@!";


                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connexion réussie à la base de données");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la connexion à la base de données");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Méthode pour fermer la connexion
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion");
                e.printStackTrace();
            }
        }
    }
}
