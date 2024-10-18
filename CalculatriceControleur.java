import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatriceControleur {
    private CalculatriceModele modele;
    private CalculatriceVue vue;

    public CalculatriceControleur(CalculatriceModele modele, CalculatriceVue vue) {
        this.modele = modele;
        this.vue = vue;

        vue.ajouterListenerBoutonChiffres(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chiffre = ((JButton) e.getSource()).getText();
                String texteActuel = vue.getAfficheur();
                vue.setAfficheur(texteActuel + chiffre);
            }
        });

        vue.ajouterListenerOperation(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operation = ((JButton) e.getSource()).getText();
                try {
                    switch (operation) {
                        case "+":
                            modele.addition();
                            break;
                        case "-":
                            modele.soustraction();
                            break;
                        case "*":
                            modele.multiplication();
                            break;
                        case "/":
                            modele.division();
                            break;
                        case "Enter":
                            double valeur = Double.parseDouble(vue.getAfficheur());
                            modele.push(valeur);
                            vue.setAfficheur("");
                            break;
                        case "Clear":
                            modele.clear();
                            vue.setAfficheur("");
                            break;
                    }
                    vue.setAfficheur(modele.afficherPile());
                } catch (Exception ex) {
                    vue.setAfficheur("Erreur: " + ex.getMessage());
                }
            }
        });
    }
}
