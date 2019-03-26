package dynamicprogram

func maxProduct1(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}

	max, min, res := nums[0], nums[0], nums[0]

	for i := 1; i < len(nums); i++ {
		tmp := max
		max = getMax(nums[i], getMax(max*nums[i], min*nums[i]))
		min = getMin(nums[i], getMin(tmp*nums[i], min*nums[i]))
		res = getMax(max, res)
	}
	return res
}

func maxProduct(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}

	mx, mn, res := nums[0], nums[0], nums[0]

	for i := 1; i < len(nums); i++ {
		if nums[i] < 0 {
			mx, mn = mn, mx
		}
		mx = getMax(nums[i], mx*nums[i])
		mn = getMin(nums[i], mn*nums[i])
		res = getMax(mx, res)
	}
	return res
}

func getMax(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func getMin(x, y int) int {
	if x > y {
		return y
	}
	return x
}
