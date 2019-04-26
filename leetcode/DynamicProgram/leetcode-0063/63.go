package arrays

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	if obstacleGrid == nil || len(obstacleGrid) == 0 || len(obstacleGrid[0]) == 0 {
		return 0
	}

	if obstacleGrid[0][0] > 0 {
		return 0
	}

	row, col := len(obstacleGrid), len(obstacleGrid[0])
	dp := make([]int, col+1)
	dp[1] = 1
	for i := 1; i < col; i++ {
		if obstacleGrid[0][i] > 0 {
			dp[i+1] = 0
		} else {
			dp[i+1] = dp[i]
		}
	}

	for i := 1; i < row; i++ {
		for j := 0; j < col; j++ {
			if obstacleGrid[i][j] > 0 {
				dp[j+1] = 0
			} else {
				dp[j+1] += dp[j]
			}
		}
	}
	return dp[col]
}
