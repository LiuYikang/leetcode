package string

import "strings"

func myAtoi(str string) int {
	var MININT = 0x80000000
	var MAXINT = 0X7FFFFFFF

	res := 0
	str = strings.TrimSpace(str)
	if len(str) == 0 {
		return res
	}

	i := 0
	flag := 1
	if str[i] == '+' {
		i++
	} else if str[i] == '-' {
		flag = -1
		i++
	}

	for i < len(str) {
		if str[i] < '0' || str[i] > '9' {
			break
		}
		res = res*10 + int(str[i]-'0')
		i++
		if flag == 1 && flag*res >= MAXINT {
			return MAXINT
		}
		if flag == -1 && res >= MININT {
			return flag * MININT
		}
	}
	return flag * res
}
