package arrays

func plusOne(digits []int) []int {
	if digits == nil || len(digits) == 0 {
		return digits
	}
	plus := 1
	for i := len(digits) - 1; i >= 0; i-- {
		digits[i] += plus
		plus = digits[i] / 10
		digits[i] %= 10
	}
	if plus > 0 {
		digits = append([]int{plus}, digits...)
	}
	return digits
}
