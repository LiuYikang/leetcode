package arrays

func majorityElement(nums []int) []int {
	t1, c1, t2, c2 := 0, 0, 0, 0

	for _, num := range nums {
		if num == t1 {
			c1++
		} else if num == t2 {
			c2++
		} else if c1 == 0 {
			t1 = num
			c1 = 1
		} else if c2 == 0 {
			t2 = num
			c2 = 1
		} else {
			c1--
			c2--
		}
	}

	c1 = 0
	c2 = 0
	for _, num := range nums {
		if num == t1 {
			c1++
		} else if num == t2 {
			c2++
		}
	}

	var res []int
	if c1 > len(nums)/3 {
		res = append(res, t1)
	}
	if c2 > len(nums)/3 {
		res = append(res, t2)
	}
	return res
}
