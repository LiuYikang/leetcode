package stack

import "container/list"

func largestRectangleArea(heights []int) int {
	if heights == nil || len(heights) == 0 {
		return 0
	}
	heights = append(heights, 0)
	i, res := 0, 0
	stack := list.New()
	for i < len(heights) {
		if stack.Len() == 0 || heights[stack.Back().Value.(int)] <= heights[i] {
			stack.PushBack(i)
			i++
		} else {
			tmp := stack.Back().Value.(int)
			stack.Remove(stack.Back())
			local := 0
			if stack.Len() == 0 {
				local = heights[tmp] * i
			} else {
				local = heights[tmp] * (i - stack.Back().Value.(int) - 1)
			}
			if local > res {
				res = local
			}
		}
	}
	return res
}
