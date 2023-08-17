package baekjoon.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// NOTE: 중간 결과가 -20억보다 크거나 같고, 20억보다 작거나 같은 입력을 고려해서 double 을 사용하는 것이 안전하다.
public class Q1935 {
    private static boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '%';
    }

    private static double calculate(double op1, double op2, char operator) {
        switch (operator) {
            case '%': return op1 % op2;
            case '*': return op1 * op2;
            case '/': return op1 / op2;
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            default: throw new IllegalArgumentException(String.format("%s is not supported.", operator));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int operandCount = Integer.parseInt(reader.readLine());
        char [] exp = reader.readLine().toCharArray();
        double [] operands = new double[operandCount];
        for (int i = 0; i < operands.length; i++) {
            operands[i] = Double.parseDouble(reader.readLine());
        }

        Stack<Double> expression = new Stack<>();
        for (char ch : exp) {
            if (!isOperator(ch)) {
                int index = ch - 'A'; // operand1 는 'A' to 'Z' 까지의 character 이므로 index 를 이렇게 구하는 것이 가능
                expression.push(operands[index]);
            } else {
                // TODO: 불 완전한 식이 들어올 경우 예외 처리
                double operand2 = expression.pop();
                double operand1 = expression.pop();
                double result = calculate(operand1, operand2, ch);
                expression.push(result);
            }
        }
        System.out.printf("%.2f", expression.pop());
    }
}
