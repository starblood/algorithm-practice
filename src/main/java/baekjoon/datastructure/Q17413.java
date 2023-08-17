package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char [] string = reader.readLine().toCharArray();
        StringBuilder result = new StringBuilder();

        // <open>tag<close>
        Stack<Character> buffer = new Stack<>();
        boolean isInTag = false;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '<') {
                isInTag = true;
                while (!buffer.isEmpty()) {
                    result.append(buffer.pop());
                }
                result.append(string[i]);
                continue;
            } else if (string[i] == '>') {
                isInTag = false;
                result.append(string[i]);
                continue;
            }

            if (isInTag) {
                result.append(string[i]);
            } else if (!isInTag) {
                if (string[i] == ' ') { // is space
                    while (!buffer.isEmpty()) {
                        result.append(buffer.pop());
                    }
                    result.append(string[i]);
                } else {
                    buffer.push(string[i]);
                }
            }
            if (i == string.length - 1) {
                while (!buffer.isEmpty()) {
                    result.append(buffer.pop());
                }
            }
        }
        System.out.println(result.toString());
    }
}
