package arrays

func generateMatrix(n int) [][]int {
	if n == 0 {
		return [][]int{}
	}
	res := make([][]int, n)
	for i := 0; i < n; i++ {
		res[i] = make([]int, n)
	}

	r, c, row, col := 0, 0, n-1, n-1
	num := 1
	for {
		for i := c; i <= col; i++ {
			res[r][i] = num
			num++
		}
		r++
		if r > row {
			break
		}

		for i := r; i <= row; i++ {
			res[i][col] = num
			num++
		}
		col--
		if c > col {
			break
		}

		for i := col; i >= c; i-- {
			res[row][i] = num
			num++
		}
		row--
		if r > row {
			break
		}

		for i := row; i >= r; i-- {
			res[i][c] = num
			num++
		}
		c++
		if c > col {
			break
		}
	}
	return res
}
