package arrays

func minSubArrayLen(s int, nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	left, right := 0, 0
	res := 0x7FFFFFFF
	sum := 0
	for right < len(nums) {
		if left < right && sum >= s {
			res = min(res, right-left)
			sum -= nums[left]
			left++
		} else {
			sum += nums[right]
			right++
		}
	}

	for sum >= s {
		res = min(res, right-left)
		sum -= nums[left]
		left++
	}
	if res == 0x7FFFFFFF {
		return 0
	}
	return res
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}
