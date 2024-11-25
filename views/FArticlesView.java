package views;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class FArticlesView extends JDialog {
    private JPanel contentPane;
    private JTable table;
    private JTextField txtCode, txtCategorie, txtDesignation, txtRecherche;
    private JFormattedTextField txtPrixUnitaire;
    private JSlider sliderQuantite;
    private JButton btnAjouter, btnModifier, btnSupprimer, btnEffacer;
    private JRadioButton rdbtnCategorie, rdbtnCode;
    private ButtonGroup groupTri;

    public FArticlesView(Window parent) {
        super(parent);

        setTitle("Gestion des Articles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 700);
        setLocationRelativeTo(null);

        createContents();
    }

    private void createContents() {
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Panneau de menu à gauche
        JPanel panelMenu = createMenuPanel();
        contentPane.add(panelMenu, BorderLayout.WEST);

        // Panneau principal au centre
        JPanel panelPrincipal = createMainPanel();
        contentPane.add(panelPrincipal, BorderLayout.CENTER);
    }

    private JPanel createMenuPanel() {
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitre = new JLabel("Articles");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelMenu.add(lblTitre, gbc);

        btnAjouter = new JButton("Ajouter");
        gbc.gridy++;
        panelMenu.add(btnAjouter, gbc);

        btnModifier = new JButton("Modifier");
        gbc.gridy++;
        panelMenu.add(btnModifier, gbc);

        btnSupprimer = new JButton("Supprimer");
        gbc.gridy++;
        panelMenu.add(btnSupprimer, gbc);

        btnEffacer = new JButton("Effacer");
        gbc.gridy++;
        panelMenu.add(btnEffacer, gbc);

        return panelMenu;
    }

    private JPanel createMainPanel() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Formulaire en haut
        JPanel panelFormulaire = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblCode = new JLabel("Code:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulaire.add(lblCode, gbc);

        txtCode = new JTextField(10);
        gbc.gridx = 1;
        panelFormulaire.add(txtCode, gbc);

        JLabel lblCategorie = new JLabel("Catégorie:");
        gbc.gridx = 2;
        panelFormulaire.add(lblCategorie, gbc);

        txtCategorie = new JTextField(10);
        gbc.gridx = 3;
        panelFormulaire.add(txtCategorie, gbc);

        JLabel lblDesignation = new JLabel("Désignation:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulaire.add(lblDesignation, gbc);

        txtDesignation = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        panelFormulaire.add(txtDesignation, gbc);

        JLabel lblQuantite = new JLabel("Quantité:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelFormulaire.add(lblQuantite, gbc);

        sliderQuantite = new JSlider(1, 100, 1);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panelFormulaire.add(sliderQuantite, gbc);

        JLabel lblPrix = new JLabel("Prix Unitaire:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panelFormulaire.add(lblPrix, gbc);

        txtPrixUnitaire = new JFormattedTextField(NumberFormat.getNumberInstance());
        txtPrixUnitaire.setColumns(10);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panelFormulaire.add(txtPrixUnitaire, gbc);

        panelPrincipal.add(panelFormulaire, BorderLayout.NORTH);

        // Tableau au centre
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Recherche en bas
        JPanel panelRecherche = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblRecherche = new JLabel("Recherche:");
        txtRecherche = new JTextField(20);

        groupTri = new ButtonGroup();
        rdbtnCode = new JRadioButton("Code");
        rdbtnCategorie = new JRadioButton("Catégorie");
        groupTri.add(rdbtnCode);
        groupTri.add(rdbtnCategorie);

        panelRecherche.add(lblRecherche);
        panelRecherche.add(txtRecherche);
        panelRecherche.add(rdbtnCode);
        panelRecherche.add(rdbtnCategorie);

        panelPrincipal.add(panelRecherche, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    // Getters pour permettre au contrôleur d'accéder aux composants
    public JButton getBtnAjouter() {
        return btnAjouter;
    }

    public JButton getBtnModifier() {
        return btnModifier;
    }

    public JButton getBtnSupprimer() {
        return btnSupprimer;
    }

    public JButton getBtnEffacer() {
        return btnEffacer;
    }

    public JTable getTable() {
        return table;
    }

    public String getCode() {
        return txtCode.getText();
    }
    public void setCode(String code) {
        txtCode.setText(code);
    }

    public String getCategorie() {
        return txtCategorie.getText();
    }

    public String getDesignation() {
        return txtDesignation.getText();
    }
    public void setDesignation(String designation) {
    txtDesignation.setText(designation);
    }

    public int getQuantite() {
        return sliderQuantite.getValue();
    }
    public void setQuantite(int quantite) {
        sliderQuantite.setValue(quantite);
    }

    public double getPrixUnitaire() {
        return ((Number) txtPrixUnitaire.getValue()).doubleValue();
    }
    public void setPrixUnitaire(double prixUnitaire) {
        txtPrixUnitaire.setValue(prixUnitaire);
    }

    public String getRecherche() {
        return txtRecherche.getText();
    }
    public void setRecherche(String recherche) {
        txtRecherche.setText(recherche);
    }
}
