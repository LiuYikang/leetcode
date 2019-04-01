package arrays

func sortColors(nums []int) {
	if nums == nil || len(nums) < 2 {
		return
	}

	p, q := 0, len(nums)-1
	i := 0
	for i < len(nums) {
		if i > p && nums[i] == 0 {
			nums[p], nums[i] = nums[i], nums[p]
			p++
		} else if i < q && nums[i] == 2 {
			nums[i], nums[q] = nums[q], nums[i]
			q--
		} else {
			i++
		}
	}
}
