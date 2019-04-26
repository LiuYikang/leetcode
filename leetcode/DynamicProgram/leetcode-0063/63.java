class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] > 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col + 1];
        dp[1] = 1;
        for (int i = 2; i <= col; i++) {
            if (obstacleGrid[0][i - 1] > 0) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] > 0) {
                    dp[j + 1] = 0;
                } else {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[col];
    }
}