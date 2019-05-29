class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int[][] xy = {{-1, -1}, {-1, 0}, {-1, 1}, 
        {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = 0;
                for (int k = 0; k < xy.length; k++) {
                    int row = i + xy[k][0];
                    int col = j + xy[k][1];
                    if (row >= 0 && row < board.length &&
                    col >= 0 && col < board[i].length && 
                    (board[row][col] == 1 || board[row][col] == 2)) {
                        count++;
                    }
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] %= 2;
            }
        }
    }
}