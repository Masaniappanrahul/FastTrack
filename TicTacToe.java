import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        char player = 'X';
        boolean running = true;

        while (running) {
            printBoard(board);
            System.out.println("Player " + player + ", enter row and column (0-2):");

            int r = sc.nextInt();
            int c = sc.nextInt();

            if (r < 0 || r > 2 || c < 0 || c > 2) {
                System.out.println("Invalid position, try again.");
                continue;
            }

            if (board[r][c] != '-') {
                System.out.println("That spot is already taken!");
                continue;
            }

            board[r][c] = player;

            if (checkWin(board, player)) {
                printBoard(board);
                System.out.println("Player " + player + " wins!");
                running = false;
            } else if (isFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                running = false;
            } else {
                player = (player == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    public static void printBoard(char[][] b) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean checkWin(char[][] b, char p) {
      
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == p && b[i][1] == p && b[i][2] == p) {
                return true;
            }
        }

      
        for (int j = 0; j < 3; j++) {
            if (b[0][j] == p && b[1][j] == p && b[2][j] == p) {
                return true;
            }
        }

        if (b[0][0] == p && b[1][1] == p && b[2][2] == p) return true;

        if (b[0][2] == p && b[1][1] == p && b[2][0] == p) return true;

        return false;
    }

    public static boolean isFull(char[][] b) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
