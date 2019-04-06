package hashtable

import "bytes"

func groupAnagrams(strs []string) [][]string {
	res := [][]string{}

	if strs == nil || len(strs) == 0 {
		return res
	}

	m := make(map[string][]string)
	for _, str := range strs {
		c := [26]int{}
		for _, v := range str {
			c[v-'a']++
		}

		buff := bytes.NewBufferString("")
		for i, v := range c {
			tmp := i + 'a'
			for j := 0; j < v; j++ {
				buff.WriteByte(byte(tmp))
			}
		}
		key := buff.String()

		if _, ok := m[key]; !ok {
			m[key] = []string{}
		}
		m[key] = append(m[key], str)
	}

	for _, v := range m {
		res = append(res, v)
	}
	return res
}
