import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatriceVue extends JFrame {
    private JTextField afficheur;
    private JButton[] boutonsChiffres;
    private JButton boutonAdd, boutonSub, boutonMul, boutonDiv, boutonEnter, boutonClear;

    public CalculatriceVue() {
        // Configuration de la fenêtre principale
        this.setTitle("Calculatrice RPN");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuration de l'afficheur
        afficheur = new JTextField();
        afficheur.setEditable(false);
        afficheur.setFont(new Font("Arial", Font.PLAIN, 24));
        this.add(afficheur, BorderLayout.NORTH);

        // Panneau des boutons
        JPanel panneauBoutons = new JPanel();
        panneauBoutons.setLayout(new GridLayout(4, 4));

        // Boutons numériques
        boutonsChiffres = new JButton[10];
        for (int i = 0; i < 10; i++) {
            boutonsChiffres[i] = new JButton(String.valueOf(i));
            panneauBoutons.add(boutonsChiffres[i]);
        }

        // Boutons d'opération
        boutonAdd = new JButton("+");
        boutonSub = new JButton("-");
        boutonMul = new JButton("*");
        boutonDiv = new JButton("/");
        boutonEnter = new JButton("Enter");
        boutonClear = new JButton("Clear");

        panneauBoutons.add(boutonAdd);
        panneauBoutons.add(boutonSub);
        panneauBoutons.add(boutonMul);
        panneauBoutons.add(boutonDiv);
        panneauBoutons.add(boutonEnter);
        panneauBoutons.add(boutonClear);

        this.add(panneauBoutons, BorderLayout.CENTER);
    }

    // Méthodes pour accéder aux composants
    public String getAfficheur() {
        return afficheur.getText();
    }

    public void setAfficheur(String texte) {
        afficheur.setText(texte);
    }

    public void ajouterListenerBoutonChiffres(ActionListener ecouteur) {
        for (JButton bouton : boutonsChiffres) {
            bouton.addActionListener(ecouteur);
        }
    }

    public void ajouterListenerOperation(ActionListener ecouteur) {
        boutonAdd.addActionListener(ecouteur);
        boutonSub.addActionListener(ecouteur);
        boutonMul.addActionListener(ecouteur);
        boutonDiv.addActionListener(ecouteur);
        boutonEnter.addActionListener(ecouteur);
        boutonClear.addActionListener(ecouteur);
    }
}
