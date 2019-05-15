package binarysearch

func findMin(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	left, right := 0, len(nums)-1
	for left < right-1 {
		mid := (right-left)/2 + left
		for mid < right && nums[mid] == nums[right] {
			right--
		}

		if mid == right {
			continue
		}

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
