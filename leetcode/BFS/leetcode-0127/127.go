package bfs

func ladderLength(beginWord string, endWord string, wordList []string) int {
	set := make(map[string]int)
	for i := 0; i < len(wordList); i++ {
		set[wordList[i]] = 1
	}
	if _, ok := set[endWord]; !ok {
		return 0
	}

	m := make(map[string]int)
	m[beginWord] = 1

	q := []string{beginWord}

	for len(q) > 0 {
		word := q[0]
		q = q[1:]
		for i := 0; i < len(word); i++ {
			byteWord := []byte(word)
			for c := 'a'; c <= 'z'; c++ {
				byteWord[i] = byte(c)
				newWord := string(byteWord)
				if set[newWord] > 0 && newWord == endWord {
					return m[word] + 1
				}
				if set[newWord] > 0 && m[newWord] == 0 {
					m[newWord] = m[word] + 1
					q = append(q, newWord)
				}
			}
		}
	}
	return 0
}
