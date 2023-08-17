package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*  print N Base number for given decimal number
    1. use iteration
    2. use recursive call

    time complexity is O(log n)
 */
public class DecimalToNBase {
    // you can use switch expression alternatively,
    // use more memory for fast execution or use more cpu time for less memory
    private static final Map<Integer, Character> DECIMAL_TO_HEX = new HashMap<>() {{
        put(10, 'A');
        put(11, 'B');
        put(12, 'C');
        put(13, 'D');
        put(14, 'E');
        put(15, 'F');
    }};

    public static String toNBase(int decimal, int base) {
        Stack<Integer> remainders = new Stack<>();

        int result = decimal;
        while (result > 0) {
            int remainder = result % base;
            remainders.push(remainder);

            result = result / base;
        }

        return getNBaseString(remainders);
    }

    private static String getNBaseString(Stack<Integer> remainders) {
        StringBuilder sb = new StringBuilder();
        while (!remainders.empty()) {
            int number = remainders.pop();
            if (DECIMAL_TO_HEX.containsKey(number)) {
                sb.append(DECIMAL_TO_HEX.get(number));
            } else {
                sb.append(number);
            }
        }
        return sb.toString();
    }

    public static String toNBaseRecursive(int decimal, int base) {
        Stack<Integer> remainders = new Stack<>();
        toNBase(decimal, base, remainders);

        return getNBaseString(remainders);
    }

    private static void toNBase(int decimal, int base, Stack<Integer> remainders) {
        int result = decimal / base;
        int remainder = decimal % base;

        remainders.push(remainder);
        if (result > 0) {
            toNBase(result, base, remainders);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split(" ");

        int number = Integer.parseInt(input[0]);
        int base = Integer.parseInt(input[1]);

        System.out.println(toNBase(number, base));
        System.out.println(toNBaseRecursive(number, base));
    }
}
