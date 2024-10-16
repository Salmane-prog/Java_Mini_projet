import java.util.Stack;

public class CalculatriceModele {
    private Stack<Double> pile;

    public CalculatriceModele() {
        pile = new Stack<>();
    }

    public void push(double valeur) {
        pile.push(valeur);
    }

    public double pop() throws Exception {
        if (pile.isEmpty()) {
            throw new Exception("La pile est vide");
        }
        return pile.pop();
    }

    public void addition() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes");
        }
        double a = pop();
        double b = pop();
        pile.push(a + b);
    }

    public void soustraction() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes");
        }
        double a = pop();
        double b = pop();
        pile.push(b - a);
    }

    public void multiplication() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes");
        }
        double a = pop();
        double b = pop();
        pile.push(a * b);
    }

    public void division() throws Exception {
        if (pile.size() < 2) {
            throw new Exception("Pas assez d'opérandes");
        }
        double a = pop();
        double b = pop();
        if (a == 0) {
            throw new ArithmeticException("Division par zéro");
        }
        pile.push(b / a);
    }

    public String afficherPile() {
        return pile.toString();
    }

    public void clear() {
        pile.clear();
    }
}
