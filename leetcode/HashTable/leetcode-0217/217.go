package hashtable

import "sort"

func containsDuplicate(nums []int) bool {
	if nums == nil || len(nums) == 0 {
		return false
	}
	sort.Ints(nums)
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1] {
			return true
		}
	}
	return false
}
