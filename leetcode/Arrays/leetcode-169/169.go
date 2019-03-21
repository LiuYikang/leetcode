func majorityElement(nums []int) int {
	count, target := 1, nums[0]

	for i := 1; i < len(nums); i++ {
		if target == nums[i] {
			count++
		} else {
			count--
			if count == 0 {
				target = nums[i]
				count++
			}
		}
	}

	return target
}