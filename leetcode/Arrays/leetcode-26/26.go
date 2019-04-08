package arrays

func removeDuplicates(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	p, t := 1, nums[0]

	for i := 1; i < len(nums); i++ {
		if nums[i] != t {
			nums[p] = nums[i]
			p++
			t = nums[i]
		}
	}
	return p
}
