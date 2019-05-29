package arrays

func gameOfLife(board [][]int) {
	if board == nil || len(board) == 0 || len(board[0]) == 0 {
		return
	}

	xy := [][]int{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			count := 0
			for k := 0; k < len(xy); k++ {
				row := i + xy[k][0]
				col := j + xy[k][1]
				if row >= 0 && row < len(board) && col >= 0 && col < len(board[0]) && (board[row][col] == 1 || board[row][col] == 2) {
					count++
				}
			}
			if board[i][j] == 0 && count == 3 {
				board[i][j] = 3
			} else if board[i][j] == 1 && (count < 2 || count > 3) {
				board[i][j] = 2
			}
		}
	}

	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			board[i][j] %= 2
		}
	}
}
