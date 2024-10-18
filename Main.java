public class Main {
    public static void main(String[] args) {
        // Create the model
        CalculatorModel model = new CalculatorModel();

        // Create the view
        CalculatorView view = new CalculatorView();

        // Create the controller and link it with the model and view
        CalculatorController controller = new CalculatorController(model, view);

        // Show the GUI
        view.setVisible(true);
    }
}
