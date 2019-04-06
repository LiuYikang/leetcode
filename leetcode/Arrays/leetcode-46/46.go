package arrays

import "sort"

func permute(nums []int) [][]int {
	res := [][]int{}
	if nums == nil || len(nums) == 0 {
		return res
	}

	sort.Ints(nums)
	tmp := []int{}
	for _, v := range nums {
		tmp = append(tmp, v)
	}
	res = append(res, tmp)

	tmp = nextPermute(nums)
	for len(tmp) > 0 {
		res = append(res, tmp)
		tmp = nextPermute(nums)
	}
	return res
}

func nextPermute(nums []int) []int {
	res := []int{}
	if nums == nil || len(nums) == 0 {
		return res
	}

	firstSmall := -1
	for i := len(nums) - 2; i >= 0; i-- {
		if nums[i] < nums[i+1] {
			firstSmall = i
			break
		}
	}

	if firstSmall == -1 {
		return res
	}

	for i := len(nums) - 1; i > firstSmall; i-- {
		if nums[i] > nums[firstSmall] {
			nums[i], nums[firstSmall] = nums[firstSmall], nums[i]
			break
		}
	}

	i, j := firstSmall+1, len(nums)-1
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}

	for _, v := range nums {
		res = append(res, v)
	}
	return res
}
