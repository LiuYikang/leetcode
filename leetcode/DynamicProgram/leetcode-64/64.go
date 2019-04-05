package dynamicprogram

func minPathSum(grid [][]int) int {
	if grid == nil || len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	row, col := len(grid), len(grid[0])
	dp := make([]int, col)

	dp[0] = grid[0][0]

	for i := 1; i < col; i++ {
		dp[i] = dp[i-1] + grid[0][i]
	}

	for i := 1; i < row; i++ {
		for j := 0; j < col; j++ {
			if j == 0 {
				dp[j] += grid[i][j]
			} else if dp[j] < dp[j-1] {
				dp[j] = dp[j] + grid[i][j]
			} else {
				dp[j] = dp[j-1] + grid[i][j]
			}
		}
	}
	return dp[col-1]
}
