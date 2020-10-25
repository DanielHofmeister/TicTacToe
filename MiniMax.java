public class MiniMax {
    static char player = 'O', opponent = 'X';

    private static int miniMax (char[][] board, Boolean isMax) {
        int score = gameOver(board);
        if (score == 1) {
            return score;
        }
        if (score == -1) {
            return score;
        }
        if (boardFull(board)) {
            return 0;
        }
        if (isMax) 
        { 
            int best = Integer.MIN_VALUE; 
            for (int i = 0; i < 3; i++) { 
                for (int j = 0; j < 3; j++) { 
                    if (board[i][j] == '-') { 
                        board[i][j] = player; 
                        best = Math.max(best, miniMax(board, !isMax)); 
                        board[i][j] = '-'; 
                    } 
                }
            } 
            return best; 
        } else { 
            int best = 1000; 
            for (int i = 0; i < 3; i++) { 
                for (int j = 0; j < 3; j++) { 
                    if (board[i][j] == '-') { 
                        board[i][j] = opponent; 
                        best = Math.min(best, miniMax(board, !isMax)); 
                        board[i][j] = '-'; 
                    } 
                } 
            } 
            return best; 
        } 
    }

    private static boolean boardFull (char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    private static int gameOver (char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == player) {
                    return 1;
                } else if (board[i][0] == opponent){
                    return -1;
                }
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == player) {
                    return 1;
                } else if (board[0][i] == opponent){
                    return -1;
                }
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == player) {
                return 1;
            } else if (board[0][0] == opponent) {
                return -1;
            }
        }
        else if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            if (board[2][0] == player) {
                return 1;
            } else if (board[2][0] == opponent) {
                return -1;
            } 
        }
        return 0;
    }

    public static int[] bestMove(char board[][]) { 
    int bestVal = Integer.MIN_VALUE; 
    int[] bestMove = new int[]{-1,-1};
  
    for (int i = 0; i < 3; i++) { 
        for (int j = 0; j < 3; j++) { 
            if (board[i][j] == '-') { 
                board[i][j] = player; 
                int moveVal = miniMax(board, false); 
                board[i][j] = '-'; 
                if (moveVal > bestVal) { 
                    bestMove[0] = i; 
                    bestMove[1] = j; 
                    bestVal = moveVal; 
                } 
            } 
        } 
    } 
    return bestMove; 
} 
}
