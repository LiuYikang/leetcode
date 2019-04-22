class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i + j >= row - 1) {
                    continue;
                }
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[col - 1 - j][row - 1 - i];
                matrix[col - 1 - j][row - 1 - i] = tmp;
            }
        }
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - 1 - i][j];
                matrix[row - 1 - i][j] = tmp;
            }
        }
    }
}