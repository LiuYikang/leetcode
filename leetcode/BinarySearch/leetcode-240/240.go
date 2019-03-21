func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}
	row, colume := 0, len(matrix[0]) - 1
	for row < len(matrix) && colume >= 0{
		if target == matrix[row][colume] {
			return true
		} else if (target < matrix[row][colume]) {
			row++
		} else {
			colume--
		}
	}
	return false
}