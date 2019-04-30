package arrays

func removeDuplicates(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	count := 1
	p, q := 1, 1
	for q < len(nums) {
		if nums[q] == nums[p-1] {
			if count >= 2 {
				q++
				continue
			} else {
				nums[p] = nums[q]
				p++
				q++
				count++
			}
		} else {
			nums[p] = nums[q]
			p++
			q++
			count = 1
		}
	}
	return p
}
