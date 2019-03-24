package sort

import (
	"sort"
	"strconv"
)

func largestNumber(nums []int) string {
	if len(nums) == 0 {
		return "0"
	}

	strs := make([]string, len(nums))
	for i := 0; i < len(nums); i++ {
		strs[i] = strconv.Itoa(nums[i])
	}

	//quickSort(strs, 0, len(strs)-1)
	sort.Slice(strs, func(i, j int) bool {
		str1 := strs[i] + strs[j]
		str2 := strs[j] + strs[i]
		if str1 > str2 {
			return true
		}
		return false
	})
	var res string
	for _, str := range strs {
		res += str
	}

	if len(res) != 0 && res[0] == '0' {
		return "0"
	}
	return res
}

func quickSort(strs []string, start, end int) {
	if start >= end {
		return
	}
	pivot := strs[end]
	pos := start
	i := start
	for i < end {
		if compare(strs[i], pivot) {
			strs[i], strs[pos] = strs[pos], strs[i]
			pos++
		}
		i++
	}
	strs[pos], strs[end] = strs[end], strs[pos]
	quickSort(strs, start, pos-1)
	quickSort(strs, pos+1, end)
}

func compare(str1, str2 string) bool {
	return (str1 + str2) > (str2 + str1)
}
