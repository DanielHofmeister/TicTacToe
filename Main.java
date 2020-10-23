import java.util.Scanner;

class Main {
    static int numMoves = 0;
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        setup(board);
        printOutline(board);
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to play tic tac toe? (Y/N)");
        String input = sc.nextLine();
        do {
            System.out.println("Number of Players? (1/2)");
            input = sc.nextLine();
            if (input.equals("1")) {
                onePlayer();
            }
            if (input.equals("2")) {
                twoPlayer(sc, board);
            }

        } while (!input.equalsIgnoreCase("N"));

        sc.close();
    }
    private static void setup(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    private static void printOutline(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    private static void onePlayer() {

    }
    private static void twoPlayer(Scanner sc, char[][] board) {
        while (numMoves < 9) {
            // Player 1
            if (numMoves%2 == 0) {
                System.out.println("Player One's Turn: Enter a coordinate");
                String input = sc.nextLine();
                int row = input.charAt(0);
                int col = input.charAt(1);
                if (validSquare(board, row, col)) {
                    board[row][col] = 'x';
                } else {
                    System.out.println("Invalid Coordinate");
                }
            } 
            // Player 2
            else {
                System.out.println("Player Two's Turn: Enter a coordinate");
                String input = sc.nextLine();
                
            }
        }
    }
    private static boolean validSquare(char[][]board, int row, int col) {

    }
}