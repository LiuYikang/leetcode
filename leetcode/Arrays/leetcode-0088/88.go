package arrays

func merge(nums1 []int, m int, nums2 []int, n int) {
	i, p, q := m+n-1, m-1, n-1
	for p >= 0 && q >= 0 {
		if nums1[p] > nums2[q] {
			nums1[i] = nums1[p]
			i--
			p--
		} else {
			nums1[i] = nums2[q]
			i--
			q--
		}
	}

	for q >= 0 {
		nums1[i] = nums2[q]
		i--
		q--
	}
}
