package hashtable

import "strconv"

// Point : Definition for a point.
type Point struct {
	X int
	Y int
}

func maxPoints(points []Point) int {
	if points == nil || len(points) == 0 {
		return 0
	}

	res := 0
	for i := 0; i < len(points); i++ {
		m := make(map[string]int)
		dup := 1
		for j := i + 1; j < len(points); j++ {
			if points[i].X == points[j].X && points[i].Y == points[j].Y {
				dup++
				continue
			}
			dx, dy := points[i].X-points[j].X, points[i].Y-points[j].Y
			d := gcd(dx, dy)
			p := strconv.Itoa(dx/d) + "#" + strconv.Itoa(dy/d)
			m[p] = m[p] + 1
		}
		res = max(res, dup)
		for _, v := range m {
			res = max(res, v+dup)
		}
	}
	return res
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func gcd(x, y int) int {
	if y == 0 {
		return x
	}
	return gcd(y, x%y)
}
