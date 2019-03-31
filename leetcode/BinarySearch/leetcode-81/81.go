package binarysearch

func search(nums []int, target int) bool {
	if nums == nil || len(nums) == 0 {
		return false
	}

	start, end := 0, len(nums)-1
	for start < end-1 {
		mid := (end-start)/2 + start
		if nums[mid] == target {
			return true
		} else if nums[start] < nums[mid] {
			if nums[start] <= target && target < nums[mid] {
				end = mid
			} else {
				start = mid
			}
		} else if nums[start] > nums[mid] {
			if nums[mid] < target && target <= nums[end] {
				start = mid
			} else {
				end = mid
			}
		} else {
			start++
		}
	}

	if nums[start] == target {
		return true
	}
	if nums[end] == target {
		return true
	}
	return false
}
