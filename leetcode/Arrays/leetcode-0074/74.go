package arrays

func searchMatrix(matrix [][]int, target int) bool {
	if matrix == nil || len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}

	row, col := len(matrix), len(matrix[0])
	i, j := 0, col-1
	for i >= 0 && i < row && j >= 0 && j < col {
		if matrix[i][j] == target {
			return true
		} else if matrix[i][j] > target {
			j--
		} else {
			i++
		}
	}
	return false
}
