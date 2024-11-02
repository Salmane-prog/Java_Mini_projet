
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatriceControleur {
    private CalculatriceModele model;
    private CalculatriceVuee view;
    private String currentInput = "";

    public CalculatriceControleur(CalculatriceModele model, CalculatriceVuee view) {
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
                case "push":
                    if (!currentInput.isEmpty()) {
                        model.push(Double.parseDouble(currentInput));
                        currentInput = "";
                        updateView();
                    }
                    break;
                case "CE":
                    model.drop();
                    updateView();
                    break;
                case "C":
                    model.clear(); // Clear the entire stack
                    updateView();
                    break;
                case "isEmpty":
                    if (model.isEmpty()) {
                        view.displayError("Stack is empty.");
                    } else {
                        view.updateHistory("Stack is not empty.");
                    }
                    break;
                case "+":
                    model.add();
                    updateView();
                    break;
                case "-":
                    model.subtract();
                    updateView();
                    break;
                case "x":
                    model.multiply();
                    updateView();
                    break;
                case "/":
                    model.divide();
                    updateView();
                    break;
                case "SWAP":
                    model.swap();
                    updateView();
                    break;
                case "exp":
                    model.exp();
                    updateView();
                    break;
                case "log":
                    model.log();
                    updateView();
                    break;
                case "cos":
                    model.cos();
                    updateView();
                    break;
                case "Sin":
                    model.sin();
                    updateView();
                    break;
                case "Tan":
                    model.tan();
                    updateView();
                    break;
                case "+/-":
                    model.toggleSign();
                    updateView();
                    break;
                default:
                    // This case handles number input and operators like . (decimal point)
                    currentInput += input;
                    view.updateDisplay(currentInput);
                    break;
            }
        } catch (IllegalStateException | IllegalArgumentException ex) {
            view.displayError(ex.getMessage());
        }
    }

    private void updateView() {
        // Update the Resultat field with the current state of the stack
        view.updateDisplay(model.getStackAsString());

        // Update the history area to include the latest stack state
        updateHistory("Stack: " + model.getStackAsString());
    }

    private void updateHistory(String operation) {
        String currentHistory = view.getHistoryText();
        view.setHistoryText(currentHistory + "\n" + operation);
    }
}
