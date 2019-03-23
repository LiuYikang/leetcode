package arrays

func findKthLargest(nums []int, k int) int {
	left, right := 0, len(nums)-1
	for {
		pos := partition(nums, left, right)
		if pos == k-1 {
			return pos
		} else if pos > k-1 {
			right = pos - 1
		} else {
			left = pos + 1
		}
	}
}

func partition(nums []int, left, right int) int {
	pos := left
	pivot := nums[right]
	i := left

	for i < right {
		if nums[i] > pivot {
			nums[i], nums[pos] = nums[pos], nums[i]
			pos++
		}
		i++
	}
	nums[pos], nums[right] = nums[right], nums[pos]
	return pos
}
