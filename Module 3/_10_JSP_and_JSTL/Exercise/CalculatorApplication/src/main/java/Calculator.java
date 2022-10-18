public class Calculator {
    static double calculate(double firstOperand, double secondOperand, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new RuntimeException("Cannot divided by 0");
                }
        }
        return result;
    }
}
