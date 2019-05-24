package arrays

func summaryRanges(nums []int) []string {
	res := []string{}

	if nums == nil || len(nums) == 0 {
		return res
	}

	start, end := nums[0], nums[0]

	for i := 1; i < len(nums); i++ {
		if nums[i]-end == 1 {
			end = nums[i]
			continue
		} else {
			tmp := getStr(start, end)
			res = append(res, tmp)
			start = nums[i]
			end = nums[i]
		}
	}
	tmp := getStr(start, end)
	res = append(res, tmp)
	return res
}

func getStr(start, end int) string {
	if start == end {
		return strconv.Itoa(start)
	}
	return strconv.Itoa(start) + "->" + strconv.Itoa(end)
}
