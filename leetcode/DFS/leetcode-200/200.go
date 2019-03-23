package dfs

func numIslands(grid [][]byte) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}

	row, col := len(grid), len(grid[0])

	flag := make([][]bool, row)
	for i := 0; i < row; i++ {
		flag[i] = make([]bool, col)
	}
	count := 0
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if grid[i][j] == '1' && !flag[i][j] {
				count++
				dfs(grid, flag, i, j)
			}
		}
	}
	return count
}

func dfs(grid [][]byte, flag [][]bool, row, col int) {
	if row < 0 || col < 0 || row >= len(grid) || col >= len(grid[0]) {
		return
	}

	if flag[row][col] {
		return
	}

	if grid[row][col] == '0' {
		return
	}

	c := [4][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
	flag[row][col] = true
	for i := 0; i < 4; i++ {
		dfs(grid, flag, row+c[i][0], col+c[i][1])
	}
}
