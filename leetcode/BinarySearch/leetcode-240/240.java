class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        if (matrix.length == 0) {
            return false;
        }
        int row = 0, colume = matrix[0].length - 1;
        while (row < matrix.length && colume >= 0) {
            if (matrix[row][colume] == target) {
                return true;
            } else if (matrix[row][colume] < target) {
                row++;
            } else {
                colume--;
            }
        }
        return false;
    }
}