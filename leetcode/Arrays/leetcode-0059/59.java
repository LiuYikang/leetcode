class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }
        int r = 0, c = 0;
        int row = n - 1, col = n - 1;
        int num = 1;

        while (true) {
            for (int i = c; i <= col; i++) {
                res[r][i] = num++;
            }
            if (++r > row) break;

            for (int i = r; i <= row; i++) {
                res[i][col] = num++;
            }
            if (c > --col) break;

            for (int i = col; i >= c; i--) {
                res[row][i] = num++;
            }
            if (r > --row) break;

            for (int i = row; i >= r; i--) {
                res[i][c] = num++;
            }
            if (++c > col) break;
        }
        return res;
    }
}