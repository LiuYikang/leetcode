package string

func addBinary(a string, b string) string {
	res := []byte{}
	var add byte = '0'
	i, j := len(a)-1, len(b)-1
	var sum byte = '0'
	for i >= 0 && j >= 0 {
		add, sum = help(a[i], b[j], add)
		res = append(res, sum)
		i--
		j--
	}

	for i >= 0 {
		add, sum = help(a[i], '0', add)
		res = append(res, sum)
		i--
	}

	for j >= 0 {
		add, sum = help('0', b[j], add)
		res = append(res, sum)
		j--
	}

	if add != '0' {
		res = append(res, add)
	}

	for i, j = 0, len(res)-1; i < j; i, j = i+1, j-1 {
		res[i], res[j] = res[j], res[i]
	}
	return string(res)
}

func help(a, b, c byte) (byte, byte) {
	if a == '0' && b == '0' {
		return '0', c
	}
	if a == '1' && b == '1' {
		return '1', c
	}
	if c == '1' {
		return c, '0'
	}
	return '0', '1'
}
