import java.util.Stack;

public class CalculatriceModele {
    private Stack<Double> stack;

    public CalculatriceModele() {
        stack = new Stack<>();
    }

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public void add() {
        if (stack.size() >= 2) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a + b);
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    public void subtract() {
        if (stack.size() >= 2) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a - b);
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    public void multiply() {
        if (stack.size() >= 2) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a * b);
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    public void divide() {
        if (stack.size() >= 2) {
            double b = stack.pop();
            double a = stack.pop();
            if (b != 0) {
                stack.push(a / b);
            } else {
                throw new IllegalArgumentException("Division by zero");
            }
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    // New feature: switch between positive and negative
    public void toggleSign() {
        if (!stack.isEmpty()) {
            double a = stack.pop();
            stack.push(-a);
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // New feature: calculate the exponential of the top number
    public void exp() {
        if (!stack.isEmpty()) {
            double a = stack.pop();
            stack.push(Math.exp(a));
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // New feature: calculate the logarithm of the top number
    public void log() {
        if (!stack.isEmpty()) {
            double a = stack.pop();
            if (a > 0) {
                stack.push(Math.log(a));
            } else {
                throw new IllegalArgumentException("Logarithm of non-positive number");
            }
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // New feature: calculate the cosine of the top number
    public void cos() {
        if (!stack.isEmpty()) {
            double a = stack.pop();
            stack.push(Math.cos(a));
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // New feature: calculate the sine of the top number
    public void sin() {
        if (!stack.isEmpty()) {
            double a = stack.pop();
            stack.push(Math.sin(a));
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // New feature: calculate the tangent of the top number
    public void tan() {
        if (!stack.isEmpty()) {
            double a = stack.pop();
            stack.push(Math.tan(a));
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // New feature: check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // New feature: remove the last element
    public void drop() {
        if (!stack.isEmpty()) {
            stack.pop();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public void swap() {
        if (stack.size() >= 2) {
            double a = stack.pop();
            double b = stack.pop();
            stack.push(a);
            stack.push(b);
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    public void clear() {
        stack.clear();
    }

    public String getStackAsString() {
        return stack.toString();
    }
}
