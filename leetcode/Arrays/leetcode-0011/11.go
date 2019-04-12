package arrays

func maxArea(height []int) int {
	res := 0
	left, right := 0, len(height)-1

	for left < right {
		_, h := maxAndmin(height[left], height[right])
		res, _ = maxAndmin(res, h*(right-left))

		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return res
}

func maxAndmin(x, y int) (int, int) {
	if x > y {
		return x, y
	}
	return y, x
}
