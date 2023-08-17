package algorithms.dp;

/* example of dynamic programming, using memoization */
public class Fibonacci {
    public static int fibonacci(int n) {
        int [] memo = new int[n + 1];
        memo[0] = 1; memo[1] = 1;

        if (n < 2) {
            return memo[n];
        }
        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n];
    }

    public static int fibonacci(int [] memo, int n) {
        if (memo[n] > 0) {
            return memo[n];
        }

        if (n <= 1) {
            memo[n] = 1;
            return memo[n];
        } else {
            memo[n] = fibonacci(memo, n - 2) + fibonacci(memo, n - 1);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        System.out.println("fibonacci 10: " + fibonacci(10));
        System.out.println("fibonacci 10: " + fibonacci(new int[11], 10));
    }
}
