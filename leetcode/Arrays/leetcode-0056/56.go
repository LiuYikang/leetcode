package arrays

import "sort"

func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 || len(intervals[0]) == 0 {
		return intervals
	}

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	res := [][]int{}
	tmp := intervals[0]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] <= tmp[1] {
			if intervals[i][1] > tmp[1] {
				tmp[1] = intervals[i][1]
			}
		} else {
			res = append(res, tmp)
			tmp = intervals[i]
		}
	}
	res = append(res, tmp)
	return res
}
