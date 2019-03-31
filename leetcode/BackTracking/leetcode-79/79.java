class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flag[i][j] = false;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (helper(board, i, j, flag, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int row, int col, boolean[][] flag, String word, int loc) {
        if (loc == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (flag[row][col] == true) {
            return false;
        }

        if (board[row][col] != word.charAt(loc)) {
            return false;
        }
        
        flag[row][col] = true;
        int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            if (helper(board, row + next[i][0], col + next[i][1], flag, word, loc + 1)) {
                return true;
            }
        }
        flag[row][col] = false;
        return false;
    }
}