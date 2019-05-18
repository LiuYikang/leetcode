package backtracking

func combinationSum3(k int, n int) [][]int {
	res := [][]int{}
	array := []int{}
	helper(k, n, 1, 0, array, &res)
	return res
}

func helper(k, n, start, sum int, array []int, res *[][]int) {
	if len(array) == k && sum == n {
		tmp := make([]int, len(array))
		copy(tmp, array)
		*res = append(*res, tmp)
		return
	}

	if len(array) >= k {
		return
	}

	for i := start; i <= 9; i++ {
		array = append(array, i)
		helper(k, n, i+1, sum+i, array, res)
		array = array[:len(array)-1]
	}
}
