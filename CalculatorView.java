import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorView extends JFrame {
    private JTextField display;
    private List<JButton> buttons; // List of buttons for easy access in the controller

    public CalculatorView() {
        // Setup the main window
        setTitle("RPN Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display (output field)
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Initialize buttons and add them to the panel
        buttons = new ArrayList<>();
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "+", "swap"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttons.add(button);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    // Method to return the list of buttons to the controller
    public List<JButton> getButtons() {
        return buttons;
    }

    // Method to update the display based on the stack contents
    public void updateDisplay(String text) {
        display.setText(text);
    }

    // Method to display an error message
    public void displayError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Main method to launch the view
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        view.setVisible(true);
    }
}
