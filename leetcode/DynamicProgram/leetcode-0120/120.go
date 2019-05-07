package dynamicprogram

func minimumTotal(triangle [][]int) int {
	if triangle == nil || len(triangle) == 0 || len(triangle[0]) == 0 {
		return 0
	}

	row := len(triangle)
	dp := make([]int, row)
	for i := 0; i < row; i++ {
		dp[i] = triangle[row-1][i]
	}

	for i := row - 2; i >= 0; i-- {
		for j := 0; j <= i; j++ {
			dp[j] = min(dp[j], dp[j+1]) + triangle[i][j]
		}
	}
	return dp[0]
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
