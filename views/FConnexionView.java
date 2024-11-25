package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FConnexionView extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel contentPane;
    public JTextField txtSaisieUtilisateur;
    public JPasswordField pwdMotDePasse;
    public JButton btnQuitter;
    public JButton btnValider;

    public FConnexionView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 370);
        setTitle("Gestion Aichi");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_global = new JPanel();
        panel_global.setBorder(new CompoundBorder(new EmptyBorder(14, 14, 14, 14),
                new LineBorder(new Color(0x33, 0XB5, 0XE5), 3, true)));
        contentPane.add(panel_global, BorderLayout.CENTER);
        panel_global.setLayout(new BorderLayout(0, 0));

        JPanel panel_connexion = new JPanel();
        panel_connexion.setBackground(Color.WHITE);
        panel_connexion.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel_global.add(panel_connexion);
        GridBagLayout gbl_panel_connexion = new GridBagLayout();
        gbl_panel_connexion.columnWidths = new int[]{134, 525, 0};
        gbl_panel_connexion.rowHeights = new int[]{26, 26, 66, 0};
        gbl_panel_connexion.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panel_connexion.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_connexion.setLayout(gbl_panel_connexion);

        JLabel lblUtilisateur = new JLabel("Nom d'utilisateur");
        lblUtilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
        GridBagConstraints gbc_lblUtilisateur = new GridBagConstraints();
        gbc_lblUtilisateur.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblUtilisateur.insets = new Insets(0, 0, 5, 5);
        gbc_lblUtilisateur.gridx = 0;
        gbc_lblUtilisateur.gridy = 0;
        panel_connexion.add(lblUtilisateur, gbc_lblUtilisateur);

        txtSaisieUtilisateur = new JTextField();
        GridBagConstraints gbc_txtSaisieUtilisateur = new GridBagConstraints();
        gbc_txtSaisieUtilisateur.insets = new Insets(0, 0, 5, 0);
        gbc_txtSaisieUtilisateur.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSaisieUtilisateur.gridx = 1;
        gbc_txtSaisieUtilisateur.gridy = 0;
        panel_connexion.add(txtSaisieUtilisateur, gbc_txtSaisieUtilisateur);
        txtSaisieUtilisateur.setColumns(10);

        JLabel lblMotDePasse = new JLabel("Mot de passe");
        lblMotDePasse.setHorizontalAlignment(SwingConstants.TRAILING);
        GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
        gbc_lblMotDePasse.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
        gbc_lblMotDePasse.gridx = 0;
        gbc_lblMotDePasse.gridy = 1;
        panel_connexion.add(lblMotDePasse, gbc_lblMotDePasse);

        pwdMotDePasse = new JPasswordField();
        pwdMotDePasse.setText("javaSestSuper");
        GridBagConstraints gbc_pwdMotDePasse = new GridBagConstraints();
        gbc_pwdMotDePasse.insets = new Insets(0, 0, 5, 0);
        gbc_pwdMotDePasse.fill = GridBagConstraints.HORIZONTAL;
        gbc_pwdMotDePasse.gridx = 1;
        gbc_pwdMotDePasse.gridy = 1;
        panel_connexion.add(pwdMotDePasse, gbc_pwdMotDePasse);

        JTextPane txtpnInfo = new JTextPane();
        txtpnInfo.setText("Veuillez saisir \nle nom de l'utilisateur et le mot de passe \npour accéder à l'application");
        txtpnInfo.setForeground(Color.GRAY);
        txtpnInfo.setBackground(Color.WHITE);
        GridBagConstraints gbc_txtpnInfo = new GridBagConstraints();
        gbc_txtpnInfo.insets = new Insets(5, 0, 0, 0);
        gbc_txtpnInfo.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtpnInfo.gridwidth = 2;
        gbc_txtpnInfo.gridx = 0;
        gbc_txtpnInfo.gridy = 2;
        panel_connexion.add(txtpnInfo, gbc_txtpnInfo);

        JPanel panel_actions = new JPanel();
        panel_actions.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(panel_actions, BorderLayout.SOUTH);

        btnValider = new JButton("Valider");
        panel_actions.add(btnValider);

        btnQuitter = new JButton("Quitter");
        panel_actions.add(btnQuitter);
    }
}
