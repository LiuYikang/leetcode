class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length - 1, col = matrix[0].length - 1;
        int r = 0, c = 0;
        while (true) {
            for (int i = c; i <= col; i++) {
                res.add(matrix[r][i]);
            }
            if (++r > row) {
                break;
            }

            for (int i = r; i <= row; i++) {
                res.add(matrix[i][col]);
            }
            if (c > --col) {
                break;
            }

            for (int i = col; i >= c; i--) {
                res.add(matrix[row][i]);
            }
            if (r > --row) {
                break;
            }

            for (int i = row; i >= r; i--) {
                res.add(matrix[i][c]);
            }
            if (++c > col) {
                break;
            }
        }
        return res;
    }
}