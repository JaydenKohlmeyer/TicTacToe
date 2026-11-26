import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char player = 'X';
        int moves = 0;

        while (moves < 9) {

            // Print board
            for (int i = 0; i < 3; i++) {
                System.out.println(board[i][0] + " | " +
                                   board[i][1] + " | " +
                                   board[i][2]);
                System.out.println("---------");
            }

            // Player chooses position
            System.out.println("Player " + player + "'s turn");

            System.out.print("Enter row (1-3): ");
            int row = input.nextInt() - 1;

            System.out.print("Enter column (1-3): ");
            int col = input.nextInt() - 1;

            // Check that the chosen box is empty
            if (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == ' ') {

                board[row][col] = player;
                moves++;

                // Check rows for a win
                for (int i = 0; i < 3; i++) {
                    if (board[i][0] == player &&
                        board[i][1] == player &&
                        board[i][2] == player) {
                        System.out.println(player + " wins!");
                        input.close();
                        return;
                    }
                }

                // Check columns for a win
                for (int i = 0; i < 3; i++) {
                    if (board[0][i] == player &&
                        board[1][i] == player &&
                        board[2][i] == player) {
                        System.out.println(player + " wins!");
                        input.close();
                        return;
                    }
                }

                // Switch players
                if (player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }

            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        System.out.println("It's a draw!");

        input.close();
    }
}