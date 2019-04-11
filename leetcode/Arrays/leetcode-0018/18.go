package arrays

import "sort"

func fourSum(nums []int, target int) [][]int {
	res := [][]int{}

	sort.Ints(nums)

	for i := 0; i < len(nums)-3; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		for j := i + 1; j < len(nums)-2; j++ {
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}

			low, high := j+1, len(nums)-1
			sum := target - nums[i] - nums[j]
			for low < high {
				if nums[low]+nums[high] == sum {
					res = append(res, []int{nums[i], nums[j], nums[low], nums[high]})
					for low < high && nums[low] == nums[low+1] {
						low++
					}
					for low < high && nums[high] == nums[high-1] {
						high--
					}
					low++
					high--
				} else if nums[low]+nums[high] < sum {
					low++
				} else {
					high--
				}
			}
		}
	}
	return res
}
