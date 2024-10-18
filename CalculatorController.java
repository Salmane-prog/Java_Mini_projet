import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        addEventListeners();
    }

    // Add event listeners for all buttons in the view
    private void addEventListeners() {
        for (JButton button : view.getButtons()) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    handleInput(command);  // Gérer les entrées utilisateur
                }
            });
        }
    }


    // Handle input based on the button clicked
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
                default:
                    // If input is a number, push it onto the stack
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

    // Update the view with the current state of the stack
    private void updateView() {
        view.updateDisplay(model.getStackAsString());
    }
}
