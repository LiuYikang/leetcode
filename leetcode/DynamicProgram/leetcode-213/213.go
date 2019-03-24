package dp

func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	} else if len(nums) == 1 {
		return nums[0]
	} else if len(nums) == 2 {
		return max(nums[0], nums[1])
	}

	prepre, pre := nums[0], max(nums[0], nums[1])
	res := 0

	for i := 2; i < len(nums)-1; i++ {
		tmp := pre
		pre = max(prepre+nums[i], pre)
		prepre = tmp
	}
	res = max(res, pre)

	prepre, pre = nums[1], max(nums[1], nums[2])
	for i := 3; i < len(nums); i++ {
		tmp := pre
		pre = max(prepre+nums[i], pre)
		prepre = tmp
	}
	res = max(res, pre)

	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
