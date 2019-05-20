package hashtable

func intersection(nums1 []int, nums2 []int) []int {
	res := []int{}

	m := make(map[int]int)

	for _, v := range nums1 {
		m[v] = 1
	}

	for _, v := range nums2 {
		if m[v] > 0 {
			res = append(res, v)
			m[v] = 0
		}
	}

	return res
}
