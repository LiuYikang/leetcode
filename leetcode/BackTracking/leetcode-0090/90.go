package backtracking

import "sort"

func subsetsWithDup(nums []int) [][]int {
	res := [][]int{}
	if nums == nil || len(nums) == 0 {
		return res
	}

	subset := []int{}
	sort.Ints(nums)
	helper(nums, subset, &res, 0)
	return res
}

func helper(nums, subset []int, res *[][]int, start int) {
	tmp := make([]int, len(subset))
	copy(tmp, subset)
	*res = append(*res, tmp)

	if start >= len(nums) {
		return
	}

	for i := start; i < len(nums); i++ {
		if i > start && nums[i] == nums[i-1] {
			continue
		}
		subset = append(subset, nums[i])
		helper(nums, subset, res, i+1)
		subset = subset[:len(subset)-1]
	}
}
