package string

import "strings"

func longestCommonPrefix(strs []string) string {
	if strs == nil || len(strs) == 0 {
		return ""
	}

	prefix := strs[0]
	for _, v := range strs[1:] {
		for strings.Index(v, prefix) != 0 {
			prefix = prefix[:len(prefix)-1]
		}
	}
	return prefix
}
