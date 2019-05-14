package unionfind

func longestConsecutive(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	set := make(map[int]int)
	for _, num := range nums {
		set[num] = 1
	}

	res := 0
	for _, num := range nums {
		if _, ok := set[num]; !ok {
			continue
		}
		delete(set, num)
		pre := num - 1
		next := num + 1
		for set[pre] > 0 {
			delete(set, pre)
			pre--
		}
		for set[next] > 0 {
			delete(set, next)
			next++
		}

		if next-pre-1 > res {
			res = next - pre - 1
		}
	}
	return res
}
