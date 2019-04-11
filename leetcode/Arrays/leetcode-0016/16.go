package arrays

import (
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	res := nums[0] + nums[1] + nums[2]

	sort.Ints(nums)

	for i := 0; i < len(nums)-2; i++ {
		low, high := i+1, len(nums)-1
		for low < high {
			sum := nums[i] + nums[low] + nums[high]
			if abs(sum, target) < abs(res, target) {
				res = sum
			}
			if sum < target {
				low++
			} else {
				high--
			}
		}
	}
	return res
}

func abs(x, y int) int {
	if x > y {
		return x - y
	}
	return y - x
}
