/**
290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
**/
func wordPattern(pattern string, str string) bool {
	if pattern == "" && str == "" {
		return true
	}

	if pattern == "" || str == "" {
		return false
	}

	strs := strings.split(str, " ")
	chars := strings.split(pattern, "")
	if len(chars) != len(strs) {
		return false
	}

	return isMatch(chars, strs) && isMatch(strs, chars)
}

func isMatch(strs1 []string, strs2 []string) bool {
	m := make(map[string]string, len(strs1))

	for i := 0; i < len(strs1); i++ {
		if _, ok := m[strs1[i]]; ok {
			if strs2[i] != m[strs1[i]] {
				return false
			}
		} else {
			m[strs1[i]] = strs2[i]
		}
	}
	return true
}