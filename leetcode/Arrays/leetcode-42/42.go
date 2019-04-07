package arrays

func trap(height []int) int {
	left, right := 0, len(height)-1
	leftMax, rightMax := 0, 0
	res := 0

	for left < right {
		if height[left] < height[right] {
			leftMax = max(leftMax, height[left])
			res += leftMax - height[left]
			left++
		} else {
			rightMax = max(rightMax, height[right])
			res += rightMax - height[right]
			right--
		}
	}
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
