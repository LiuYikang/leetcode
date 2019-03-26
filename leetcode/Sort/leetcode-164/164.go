package sort

import "math"

func maximumGap(nums []int) int {
	if nums == nil || len(nums) < 2 {
		return 0
	}

	l, max, min := len(nums), nums[0], nums[0]

	for _, num := range nums {
		if num > max {
			max = num
		}
		if num < min {
			min = num
		}
	}

	bCap := (max-min)/l + 1
	bCnt := (max-min)/bCap + 1
	bMax := make([]int, bCnt)
	bMin := make([]int, bCnt)
	for i := 0; i < bCnt; i++ {
		bMax[i] = math.MinInt32
		bMin[i] = math.MaxInt32
	}

	set := map[int]bool{}

	for _, num := range nums {
		idx := (num - min) / bCap
		if num > bMax[idx] {
			bMax[idx] = num
		}
		if num < bMin[idx] {
			bMin[idx] = num
		}
		set[idx] = true
	}

	pre, res := 0, 0
	for _, ok := set[pre]; !ok; pre++ {
	}

	for i := pre + 1; i < bCnt; i++ {
		if _, ok := set[i]; !ok {
			continue
		}
		if res < bMin[i]-bMax[pre] {
			res = bMin[i] - bMax[pre]
		}
		pre = i
	}
	return res
}
