import java.util.Stack;

public class CalculatorModel {
    // Stack to hold the numbers for RPN calculations
    private Stack<Double> stack;

    public CalculatorModel() {
        stack = new Stack<>();
    }

    // Push a number onto the stack
    public void push(double value) {
        stack.push(value);
    }

    // Pop the top number from the stack
    public double pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // Add the top two numbers on the stack
    public void add() {
        if (stack.size() >= 2) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a + b);
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    // Subtract the top two numbers on the stack
    public void subtract() {
        if (stack.size() >= 2) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a - b);
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    // Multiply the top two numbers on the stack
    public void multiply() {
        if (stack.size() >= 2) {
            double b = stack.pop();
            double a = stack.pop();
            stack.push(a * b);
        } else {
            throw new IllegalStateException("Not enough operands");
        }
    }

    // Divide the top two numbers on the stack
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

    // Get the top number on the stack (without removing it)
    public double peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // Swap the top two numbers on the stack
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

    // Clear the stack
    public void clear() {
        stack.clear();
    }

    // Get the size of the stack
    public int getStackSize() {
        return stack.size();
    }

    // For debugging: get the entire stack as a string
    public String getStackAsString() {
        return stack.toString();
    }
}
