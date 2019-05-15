package arrays

func rotate(nums []int, k int) {
	if nums == nil || len(nums) == 0 {
		return
	}

	if k > len(nums) {
		k -= len(nums)
	}

	help(nums, 0, len(nums)-1)
	help(nums, 0, k-1)
	help(nums, k, len(nums)-1)
}

func help(nums []int, start, end int) {
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}
