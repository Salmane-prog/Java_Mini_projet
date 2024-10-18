public class Main {
    public static void main(String[] args) {
        CalculatriceModele modele = new CalculatriceModele();
        CalculatriceVue vue = new CalculatriceVue();
        new CalculatriceControleur(modele, vue);
        vue.setVisible(true);
    }
}
