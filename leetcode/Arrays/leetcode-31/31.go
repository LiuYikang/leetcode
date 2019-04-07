package arrays

func nextPermutation(nums []int) {
	if nums == nil || len(nums) == 0 {
		return
	}

	firstSmall := -1

	for i := len(nums) - 2; i >= 0; i-- {
		if nums[i] < nums[i+1] {
			firstSmall = i
			break
		}
	}

	if firstSmall == -1 {
		reverse(nums, 0, len(nums)-1)
		return
	}

	for i := len(nums) - 1; i > firstSmall; i-- {
		if nums[i] > nums[firstSmall] {
			nums[i], nums[firstSmall] = nums[firstSmall], nums[i]
			break
		}
	}

	reverse(nums, firstSmall+1, len(nums)-1)
	return
}

func reverse(nums []int, x, y int) {
	for x < y {
		nums[x], nums[y] = nums[y], nums[x]
		x++
		y--
	}
}
