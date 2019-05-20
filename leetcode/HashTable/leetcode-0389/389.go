package hashtable

func findTheDifference(s string, t string) byte {
	res := uint8(0)

	res ^= t[len(t)-1]

	for i := 0; i < len(s); i++ {
		res ^= s[i]
		res ^= t[i]
	}
	return res
}
