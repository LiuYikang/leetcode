package arrays

func canJump(nums []int) bool {
	if len(nums) == 0 {
		return true
	}
	reach := 0
	for i := 0; i < len(nums); i++ {
		if reach >= len(nums)-1 {
			return true
		} else if reach < i {
			return false
		}
		if i+nums[i] > reach {
			reach = i + nums[i]
		}
	}
	return false
}
