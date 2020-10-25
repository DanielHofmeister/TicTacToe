import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    private static int numMoves = 0;
    private static Scanner sc = new Scanner(System.in);
    private static char[][] board;
    public static void main(String[] args) {
        board = new char[3][3];
        setup(board);

        System.out.println("Do you want to play tic tac toe? (Y/N)");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("N") || (input.equalsIgnoreCase("NO"))) {
            System.out.println("Thanks for playing!");
        }
        else if (input.equalsIgnoreCase("Y") || (input.equalsIgnoreCase("YES"))) {
            System.out.println("Number of Players? (1/2)");
            input = sc.nextLine();
            if (input.equals("1")) {
                onePlayer();
            }
            else if (input.equals("2")) {
                twoPlayer();
            } else {
                System.out.println("Invalid Input: " + input);
            }
        } else {
            System.out.println("Invalid Input: " + input);
        }
        sc.close();
    }
    private static void setup(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    private static void printOutline() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    private static void onePlayer() {
        boolean gameOver = false;
        int playerNum = 1;
        int[] move = new int[2];
        while (!gameOver) {
            if (playerNum == 1) {
                move = playerInput(playerNum);
            } else {
                printOutline();   
                System.out.println("Computer's Turn");
                move = MiniMax.bestMove(board);
            }
            if (playerNum == 1) {
                board[move[0]][move[1]] = 'X';
            } else {
                board[move[0]][move[1]] = 'O';
            }
            numMoves++;
            if (checkWin()) {
                System.out.println("Player " + playerNum + " wins!");
                gameOver = true;
            } else if (numMoves == 9) {
                System.out.println("Tie Game");
                gameOver = true;
            }

            if (playerNum == 1) {
                playerNum++;
            } else {
                playerNum--;
            }
        }
    }
    private static int[] playerInput(int playerNum) {
        int[] coordinate = new int[] {-1, -1};
        do {     
            printOutline();   
            try {
                System.out.println("Player " + playerNum + "'s Turn: Enter a row");
                int row = sc.nextInt();
                coordinate[0] = row;

                System.out.println("Player " + playerNum + "'s Turn: Enter a column");
                int col = sc.nextInt();
                coordinate[1] = col;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid row and column.");
                sc.nextLine();
            }
        } while (!validSquare(coordinate[0], coordinate[1]));
            return coordinate;
    }
    private static void twoPlayer() {
        boolean gameOver = false;
        int playerNum = 1;
        while (!gameOver) {
            int[] move = playerInput(playerNum);
            if (playerNum == 1) {
                board[move[0]][move[1]] = 'X';
            } else {
                board[move[0]][move[1]] = 'O';
            }
            numMoves++;
            if (checkWin()) {
                System.out.println("Player " + playerNum + " wins!");
                gameOver = true;
            } else if (numMoves == 9) {
                System.out.println("Tie Game");
                gameOver = true;
            }

            if (playerNum == 1) {
                playerNum++;
            } else {
                playerNum--;
            }
        }
    }
    private static boolean validSquare(int row, int col){
            if (row > 2 || col > 2 || row < 0 || col < 0) {
                return false;
            }
            else if (board[row][col] != '-') {
                return false;
            }
            else {
                return true;
            }
    }
    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return true;
        } else {
            return false;
        }

    }
    
}