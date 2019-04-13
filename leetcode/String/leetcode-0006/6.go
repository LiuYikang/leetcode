package string

import "strings"

func convert(s string, numRows int) string {
	if numRows <= 1 {
		return s
	}
	strs := make([]string, numRows)
	for i := 0; i < numRows; i++ {
		strs[i] = ""
	}

	for i := 0; i < len(s); i++ {
		idx := i % (2*numRows - 2)
		if idx >= numRows {
			idx = 2*numRows - 2 - idx
		}
		strs[idx] += string(s[i])
	}

	return strings.Join(strs, "")
}
