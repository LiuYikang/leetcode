package arrays

func jump(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	pre, cur, i := 0, 0, 0
	res := 0
	for cur < len(nums)-1 {
		res++
		pre = cur
		for i <= pre {
			if i+nums[i] > cur {
				cur = i + nums[i]
			}
			i++
		}
		if cur == pre {
			return -1
		}
	}
	return res
}
