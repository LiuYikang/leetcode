package binarysearch

func findMin(nums []int) int {
	if len(nums) < 2 {
		return nums[0]
	}

	left, right := 0, len(nums)-1

	for left < right-1 {
		mid := (right-left)/2 + left
		if nums[mid] < nums[right] {
			right = mid
		} else {
			left = mid
		}
	}

	if nums[left] < nums[right] {
		return nums[left]
	}
	return nums[right]
}
