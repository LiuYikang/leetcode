package arrays

func twoSum(numbers []int, target int) []int {
	if len(numbers) < 2 {
		return nil
	}

	left, right := 0, len(numbers)-1
	for left < right {
		if numbers[left]+numbers[right] < target {
			left++
		} else if numbers[left]+numbers[right] > target {
			right--
		} else {
			break
		}
	}

	if numbers[left]+numbers[right] == target && left < right {
		return []int{left + 1, right + 1}
	}
	return nil
}
