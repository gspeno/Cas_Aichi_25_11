package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDAO {
    private ConnexionDAO connectionDao;

    /*public ConnexionDAO getConnection() {
        return (ConnexionDAO) connection.getConnection();
    }*/
    public UserDAO() {
        this.connectionDao = new ConnexionDAO();
    }

    //Liste des utilisateurs pour la vérification
    public List<User> getAllUsers () {
        List<User> users = new ArrayList<>();
        try {
            Statement stmt = connectionDao.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setMdp(rs.getString("mdp"));
                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user, Connection connection) {
        try {
            String query = "INSERT INTO users (login, mdp) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getMdp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
