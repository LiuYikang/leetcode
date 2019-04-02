package binarysearch

func mySqrt(x int) int {
	if x < 2 {
		return x
	}

	left, right := 0, x
	for left < right {
		mid := (right-left)/2 + left
		if x/mid >= mid {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return right - 1
}
