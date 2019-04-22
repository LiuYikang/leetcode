package arrays

func spiralOrder(matrix [][]int) []int {
	res := []int{}
	if matrix == nil || len(matrix) == 0 || len(matrix[0]) == 0 {
		return res
	}

	r, c, row, col := 0, 0, len(matrix)-1, len(matrix[0])-1
	for {
		for i := c; i <= col; i++ {
			res = append(res, matrix[r][i])
		}
		r++
		if r > row {
			break
		}

		for i := r; i <= row; i++ {
			res = append(res, matrix[i][col])
		}
		col--
		if c > col {
			break
		}

		for i := col; i >= c; i-- {
			res = append(res, matrix[row][i])
		}
		row--
		if r > row {
			break
		}

		for i := row; i >= r; i-- {
			res = append(res, matrix[i][c])
		}
		c++
		if c > col {
			break
		}
	}
	return res
}
