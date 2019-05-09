package bfs

func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	dict := make(map[string]int)
	for _, v := range wordList {
		dict[v] = 1
	}

	res := make([][]string, 0)
	nodeNeighbors := make(map[string][]string)
	distance := make(map[string]int)
	solution := make([]string, 0)

	dict[beginWord] = 1
	bfs(beginWord, endWord, dict, distance, nodeNeighbors)
	dfs(beginWord, endWord, dict, distance, nodeNeighbors, solution, &res)
	return res
}

func bfs(beginWord, endWord string, dict, distance map[string]int, nodeNeighbors map[string][]string) {
	queue := []string{}
	queue = append(queue, beginWord)
	distance[beginWord] = 0

	for len(queue) > 0 {
		count := len(queue)
		foundEnd := false
		for i := 0; i < count; i++ {
			cur := queue[0]
			queue = queue[1:]
			curDistance := distance[cur]
			neighbors := getNeighbors(cur, dict)

			for _, neighbor := range neighbors {
				nodeNeighbors[cur] = append(nodeNeighbors[cur], neighbor)
				if _, ok := distance[neighbor]; !ok {
					distance[neighbor] = curDistance + 1
					if endWord == neighbor {
						foundEnd = true
					} else {
						queue = append(queue, neighbor)
					}
				}
			}
		}
		if foundEnd {
			break
		}
	}
}

func getNeighbors(cur string, dict map[string]int) []string {
	res := []string{}
	byteWord := []byte(cur)

	for c := 'a'; c <= 'z'; c++ {
		for i := 0; i < len(byteWord); i++ {
			if byteWord[i] == byte(c) {
				continue
			}
			old := byteWord[i]
			byteWord[i] = byte(c)
			newWord := string(byteWord)
			if _, ok := dict[newWord]; ok {
				res = append(res, newWord)
			}
			byteWord[i] = old
		}
	}
	return res
}

func dfs(curWord, endWord string, dict, distance map[string]int, nodeNeighbors map[string][]string, solution []string, res *[][]string) {
	solution = append(solution, curWord)
	if endWord == curWord {
		tmp := make([]string, len(solution))
		copy(tmp, solution)
		*res = append(*res, tmp)
	} else {
		for _, str := range nodeNeighbors[curWord] {
			if distance[str] == distance[curWord]+1 {
				dfs(str, endWord, dict, distance, nodeNeighbors, solution, res)
			}
		}
	}
	solution = solution[:len(solution)-1]
}
