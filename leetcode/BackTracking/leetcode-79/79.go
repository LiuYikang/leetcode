package backtracking

func exist(board [][]byte, word string) bool {
	if board == nil || len(board) == 0 || len(board[0]) == 0 || len(word) == 0 {
		return false
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if helper(board, i, j, word, 0) {
				return true
			}
		}
	}
	return false
}

func helper(board [][]byte, row, col int, word string, loc int) bool {
	if loc == len(word) {
		return true
	}

	if row < 0 || row >= len(board) || col < 0 || col >= len(board[0]) {
		return false
	}

	if board[row][col] == '0' {
		return false
	}

	if board[row][col] != word[loc] {
		return false
	}

	c := board[row][col]
	board[row][col] = '0'
	res := helper(board, row, col+1, word, loc+1) || helper(board, row, col-1, word, loc+1) || helper(board, row+1, col, word, loc+1) || helper(board, row-1, col, word, loc+1)

	if res == false {
		board[row][col] = c
	}

	return res
}
