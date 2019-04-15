package binarysearch

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	l1, l2 := len(nums1), len(nums2)
	if (l1+l2)%2 != 0 {
		return getKth(nums1, nums2, 0, 0, (l1+l2)/2+1)
	}
	return (getKth(nums1, nums2, 0, 0, (l1+l2)/2) + getKth(nums1, nums2, 0, 0, (l1+l2)/2+1)) / 2.0
}

func getKth(nums1, nums2 []int, start1, start2, k int) float64 {
	if start1 > len(nums1)-1 {
		return float64(nums2[start2+k-1])
	}
	if start2 > len(nums2)-1 {
		return float64(nums1[start1+k-1])
	}

	if k == 1 {
		if nums1[start1] < nums2[start2] {
			return float64(nums1[start1])
		}
		return float64(nums2[start2])
	}

	mid1, mid2 := 0x7FFFFFFF, 0x7FFFFFFF
	if start1+k/2-1 < len(nums1) {
		mid1 = nums1[start1+k/2-1]
	}
	if start2+k/2-1 < len(nums2) {
		mid2 = nums2[start2+k/2-1]
	}

	if mid1 < mid2 {
		return getKth(nums1, nums2, start1+k/2, start2, k-k/2)
	} else {
		return getKth(nums1, nums2, start1, start2+k/2, k-k/2)
	}
}
