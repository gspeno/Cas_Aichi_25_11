package main;

import controllers.FAccueilController;
import views.FAccueilView;
import views.FConnexionView;
import controllers.FConnexionController;
import models.UserDAO;

public class Main {
    public static void main(String[] args) {
        FConnexionView view = new FConnexionView();
        UserDAO userDAO = new UserDAO();
        new FConnexionController(view,userDAO);
        view.setVisible(true);


    }
}
