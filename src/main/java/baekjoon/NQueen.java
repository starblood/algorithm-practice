package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Q9663
public class NQueen {
    private static int count = 0;
    public static boolean isPromising(int [] board, int row) {
        // 같은 열이면 안되고, 대각선상에 있어서도 안 된다.
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public static void nQueen(int [] board, int startRow, int totalRowCount) {
        // 마지막 행까지 수행하고 여기까지 오면, 찾기 완료
        if (startRow == totalRowCount) {
            count++;
            return;
        }
        for (int i = 0; i < totalRowCount; i++) {
            board[startRow] = i; // startRow 번째 행, i번째 열에 queen 을 놓아본다.
            // 이후 그 행에 둔 것에 대한 유망성을 판단한다.
            if (isPromising(board, startRow)) { // 그 자리에 두어도 괜찮았다면,
                nQueen(board, startRow + 1, totalRowCount); // 그 다음 행에 대해 퀸을 놓는 것을 해 본다.
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int [] board = new int[n];

        nQueen(board, 0, n);
        System.out.println(count);
    }
}
