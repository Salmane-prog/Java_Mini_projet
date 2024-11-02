
public class Main {

    public static void main(String[] args) {
        // Initialiser le modèle, la vue, et le contrôleur
        CalculatriceModele model = new CalculatriceModele();
        CalculatriceVuee view = new CalculatriceVuee();
        CalculatriceControleur controller = new CalculatriceControleur(model, view);

        // Afficher l'interface graphique
        view.setVisible(true);
    }
}
