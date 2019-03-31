package binarysearch

func search(nums []int, target int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}

	start, end := 0, len(nums)-1
	for start < end-1 {
		mid := (end-start)/2 + start
		if nums[mid] == target {
			return mid
		} else if nums[start] < nums[mid] {
			if nums[start] <= target && target < nums[mid] {
				end = mid
			} else {
				start = mid
			}
		} else {
			if nums[mid] < target && target <= nums[end] {
				start = mid
			} else {
				end = mid
			}
		}
	}

	if nums[start] == target {
		return start
	}
	if nums[end] == target {
		return end
	}
	return -1
}
