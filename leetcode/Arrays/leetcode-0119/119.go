package arrays

func getRow(rowIndex int) []int {
	res := []int{}
	if rowIndex < 0 {
		return res
	}

	for i := 0; i <= rowIndex; i++ {
		res = append([]int{1}, res...)
		for j := 1; j < len(res)-1; j++ {
			res[j] += res[j+1]
		}
	}
	return res
}
