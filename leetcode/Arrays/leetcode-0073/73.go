package arrays

func setZeroes(matrix [][]int) {
	if matrix == nil || len(matrix) == 0 || len(matrix[0]) == 0 {
		return
	}

	rowZero, colZero := false, false
	row, col := len(matrix), len(matrix[0])
	for i := 0; i < row; i++ {
		if matrix[i][0] == 0 {
			colZero = true
			break
		}
	}

	for i := 0; i < col; i++ {
		if matrix[0][i] == 0 {
			rowZero = true
			break
		}
	}

	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			if matrix[i][j] == 0 {
				matrix[i][0] = 0
				matrix[0][j] = 0
			}
		}
	}

	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			if matrix[i][0] == 0 || matrix[0][j] == 0 {
				matrix[i][j] = 0
			}
		}
	}

	if rowZero {
		for i := 0; i < col; i++ {
			matrix[0][i] = 0
		}
	}

	if colZero {
		for i := 0; i < row; i++ {
			matrix[i][0] = 0
		}
	}
}
