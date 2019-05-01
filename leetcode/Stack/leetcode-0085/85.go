package stack

func maximalRectangle(matrix [][]byte) int {
	if matrix == nil || len(matrix) == 0 || len(matrix[0]) == 0 {
		return 0
	}
	res := 0
	row, col := len(matrix), len(matrix[0])
	height := make([]int, col+1)
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if matrix[i][j] == '1' {
				height[j]++
			} else {
				height[j] = 0
			}
		}
		local := maxRectangle(height)
		if local > res {
			res = local
		}
	}
	return res
}

func maxRectangle(height []int) int {
	if height == nil || len(height) == 0 {
		return 0
	}

	i, res := 0, 0
	s := []int{}
	for i < len(height) {
		if len(s) == 0 || height[s[len(s)-1]] <= height[i] {
			s = append(s, i)
			i++
		} else {
			tmp := s[len(s)-1]
			s = s[:len(s)-1]
			local := 0
			if len(s) == 0 {
				local = i * height[tmp]
			} else {
				local = height[tmp] * (i - s[len(s)-1] - 1)
			}
			if local > res {
				res = local
			}
		}
	}
	return res
}
