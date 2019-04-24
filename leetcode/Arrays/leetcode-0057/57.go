package arrays

func insert(intervals [][]int, newInterval []int) [][]int {
	if len(intervals) == 0 {
		intervals = append(intervals, newInterval)
	} else {
		i := 0
		for i < len(intervals) && intervals[i][0] < newInterval[0] {
			i++
		}
		if i < len(intervals) {
			intervals = append(intervals[:i+1], intervals[i:]...)
			intervals[i] = newInterval
		} else {
			intervals = append(intervals, newInterval)
		}
	}

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
