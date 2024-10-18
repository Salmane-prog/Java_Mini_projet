import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatriceVue extends JFrame {
    private JTextField display;
    private JTextArea history;  // New area for the history
    private JScrollPane scrollPane;
    private List<JButton> buttons;

    public CalculatriceVue() {
        setTitle("RPN Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        history = new JTextArea(10, 20);
        history.setEditable(false);
        scrollPane = new JScrollPane(history);
        add(scrollPane, BorderLayout.EAST);  // Add scrollable history on the right

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4));

        buttons = new ArrayList<>();
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "+", "swap",
                "exp", "log", "cos", "sin",
                "tan", "+/-", "drop", "isEmpty"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttons.add(button);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public List<JButton> getButtons() {
        return buttons;
    }

    public void updateDisplay(String text) {
        display.setText(text);
    }

    public void updateHistory(String text) {
        history.append(text + "\n");
    }

    public void displayError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        CalculatriceVue view = new CalculatriceVue();
        view.setVisible(true);
    }
}
