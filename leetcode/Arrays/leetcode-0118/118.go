package arrays

func generate(numRows int) [][]int {
	res := [][]int{}
	if numRows <= 0 {
		return res
	}

	row := []int{}
	for i := 0; i < numRows; i++ {
		row = append([]int{1}, row...)
		for j := 1; j < len(row)-1; j++ {
			row[j] += row[j+1]
		}
		res = append(res, row)
	}
	return res
}
