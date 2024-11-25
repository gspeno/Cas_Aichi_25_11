package controllers;

import models.User;
import models.UserDAO;
import views.FAccueilView;
import views.FConnexionView;

import javax.swing.*;
import java.util.List;

public class FConnexionController {
    private FConnexionView connexionView;
    private UserDAO userDAO;


    public FConnexionController(FConnexionView connexionView, UserDAO userDAO) {
        this.connexionView = connexionView;
        this.userDAO = userDAO;

        // Ajout des listeners
        this.connexionView.btnValider.addActionListener(e -> actionValider());
        this.connexionView.btnQuitter.addActionListener(e -> actionQuitter());
    }

    public String getLogin() {
        return connexionView.txtSaisieUtilisateur.getText();
    }

    public String getMotDePasse() {
        return new String(connexionView.pwdMotDePasse.getPassword());
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(connexionView, message);
    }

    private void actionQuitter() {
        connexionView.dispose();
    }


    private void actionValider() {
        String login = this.getLogin();
        String motDePasse = this.getMotDePasse();


        if (login.isEmpty() || motDePasse.isEmpty()) {
            this.showMessage("Veuillez entrer un nom d'utilisateur et un mot de passe.");
            return;
        }

        // Vérification de l'utilisateur
        List<User> users = this.userDAO.getAllUsers();
        boolean isAuthenticated = false;
        for (User user : users) {
            System.out.println(user.getMdp());
            if (user.getLogin().equals(login) && user.getMdp().equals(motDePasse)) {
                isAuthenticated = true;
                break;

            }
        }

        if (isAuthenticated) {
            this.showMessage("Connexion réussie !");
            // Logique supplémentaire après connexion, comme afficher une autre fenêtre
            this.actionQuitter();  // Fermer la fenêtre de connexion

            // Ouvrir la fenêtre principale ou la fenêtre des produits, par exemple
            FAccueilView accueilView = new FAccueilView();
            accueilView.setVisible(true);

        } else {
            this.showMessage("Nom d'utilisateur ou mot de passe incorrect.");
        }

    }



}
