package backtracking

func subsets(nums []int) [][]int {
	return helper(nums, 0)
}

func helper(nums []int, start int) [][]int {
	res := [][]int{}
	res = append(res, []int{})
	if start == len(nums) {
		return res
	}

	for i := start; i < len(nums); i++ {
		tmp := helper(nums, i+1)
		for j := range tmp {
			t := append([]int{nums[i]}, tmp[j]...)
			res = append(res, t)
		}
	}
	return res
}
