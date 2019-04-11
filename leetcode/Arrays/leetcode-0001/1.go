package arrays

func twoSum(nums []int, target int) []int {
	res := []int{}

	if len(nums) < 2 {
		return res
	}

	m := make(map[int]int)
	for i, v := range nums {
		if idx, ok := m[v]; ok {
			res = []int{idx, i}
			break
		} else {
			m[target-v] = i
		}
	}
	return res
}
