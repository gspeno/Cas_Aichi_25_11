package controllers;

import views.FArticlesView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FArticlesController {
    private FArticlesView view;

    public FArticlesController(FArticlesView view) {
        this.view = view;
        initController();
    }

    /**
     * Initialise les écouteurs pour les composants de la vue.
     */
    private void initController() {
        view.getBtnAjouter().addActionListener(e -> ajouterArticle());
        view.getBtnModifier().addActionListener(e -> modifierArticle());
        view.getBtnSupprimer().addActionListener(e -> supprimerArticle());
        view.getBtnEffacer().addActionListener(e -> effacerSaisie());
    }


    private void ajouterArticle() {
        String code = view.getCode();
        String categorie = view.getCategorie();
        String designation = view.getDesignation();
        int quantite = view.getQuantite();
        double prixUnitaire = view.getPrixUnitaire();

        if (code.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Le code est obligatoire.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            // Logique d'ajout d'article (exemple simplifié)
            System.out.println("Article ajouté : " + code + ", " + categorie + ", " + designation +
                    ", Quantité: " + quantite + ", Prix unitaire: " + prixUnitaire);
            JOptionPane.showMessageDialog(view, "Article ajouté avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);

            effacerSaisie();
        }
    }


    private void modifierArticle() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(view, "Aucun article sélectionné pour modification.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            String code = view.getCode();
            String categorie = view.getCategorie();
            String designation = view.getDesignation();
            int quantite = view.getQuantite();
            double prixUnitaire = view.getPrixUnitaire();

            if (code.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Le code est obligatoire pour modifier un article.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                // Logique de modification (exemple simplifié)
                System.out.println("Article modifié à la ligne " + selectedRow + " : " + code + ", " + categorie +
                        ", " + designation + ", Quantité: " + quantite + ", Prix unitaire: " + prixUnitaire);
                JOptionPane.showMessageDialog(view, "Article modifié avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);

                effacerSaisie();
            }
        }
    }


    private void supprimerArticle() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(view, "Aucun article sélectionné pour suppression.", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(view, "Voulez-vous vraiment supprimer cet article ?", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Logique de suppression (exemple simplifié)
                System.out.println("Article supprimé à la ligne " + selectedRow);
                JOptionPane.showMessageDialog(view, "Article supprimé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Réinitialise les champs du formulaire.
     */
    private void effacerSaisie() {
        view.setCode("");
        view.setDesignation("");
        view.setRecherche("");
        view.setQuantite(1);
        view.setPrixUnitaire(0.0);
        view.getTable().clearSelection();
    }
}
