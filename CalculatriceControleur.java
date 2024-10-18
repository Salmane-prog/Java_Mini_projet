import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatriceControleur {
    private CalculatriceModele model;
    private CalculatriceVue view;

    public CalculatriceControleur(CalculatriceModele model, CalculatriceVue view) {
        this.model = model;
        this.view = view;
        addEventListeners();
    }

    private void addEventListeners() {
        for (JButton button : view.getButtons()) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    handleInput(command);
                }
            });
        }
    }

    private void handleInput(String input) {
        try {
            switch (input) {
                case "+":
                    model.add();
                    break;
                case "-":
                    model.subtract();
                    break;
                case "*":
                    model.multiply();
                    break;
                case "/":
                    model.divide();
                    break;
                case "swap":
                    model.swap();
                    break;
                case "C":
                    model.clear();
                    break;
                case "exp":
                    model.exp();
                    break;
                case "log":
                    model.log();
                    break;
                case "cos":
                    model.cos();
                    break;
                case "sin":
                    model.sin();
                    break;
                case "tan":
                    model.tan();
                    break;
                case "+/-":
                    model.toggleSign();
                    break;
                case "drop":
                    model.drop();
                    break;
                case "isEmpty":
                    if (model.isEmpty()) {
                        view.displayError("Stack is empty");
                    } else {
                        view.updateHistory("Stack is not empty");
                    }
                    break;
                default:
                    try {
                        double value = Double.parseDouble(input);
                        model.push(value);
                    } catch (NumberFormatException ex) {
                        view.displayError("Invalid input");
                    }
            }
            updateView();
        } catch (IllegalStateException | IllegalArgumentException ex) {
            view.displayError(ex.getMessage());
        }
    }

    private void updateView() {
        view.updateDisplay(model.getStackAsString());
        view.updateHistory("Stack: " + model.getStackAsString());
    }
}
