package controllers;

import models.UserDAO;
import views.FAccueilView;
import views.FArticlesView;

import java.awt.event.*;

public class FAccueilController {
    private final FAccueilView accueilView;
    private UserDAO userDAO;


    public FAccueilController(FAccueilView view, UserDAO userDAO) {
        this.accueilView = view;
        this.userDAO = userDAO;

        System.out.println("1");
        //Ajout des listeners
        this.accueilView.getBtnArticles().addActionListener(e -> afficherArticles());

    }
    private void afficherArticles() {
        FArticlesView articlesView = new FArticlesView(this.accueilView);
        articlesView.setVisible(true);
        System.out.println("2");
    }

    // Mise à jour du texte d'information
    public void setInfoText(String text) {
        this.accueilView.getLblInfos().setText(text);
    }
}