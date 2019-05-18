package hashtable

func containsNearbyDuplicate(nums []int, k int) bool {
	if nums == nil || len(nums) == 0 {
		return false
	}
	m := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if _, ok := m[nums[i]]; ok && i-m[nums[i]] < k {
			return true
		}
		m[nums[i]] = i
	}
	return false
}
