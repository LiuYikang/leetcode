class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        sudoku = set()
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = board[i][j]
                    sudoku.add((i, num))
                    sudoku.add((num, j))
                    sudoku.add((i/3, j/3, num))
        self.SetSudokuNum(sudoku, board, 0, 0)

    def SetSudokuNum(self, sudoku, board, i, j):
        if j >= 9:
            return self.SetSudokuNum(sudoku, board, i+1, 0)
        if i == 9:
            return True
        if board[i][j] == '.':
            for num in range(1, 10):
                c = str(num)
                if (i, c) in sudoku or (c, j) in sudoku or (i/3, j/3, c) in sudoku:
                    continue
                else:
                    board[i][j] = c
                    sudoku.add((i, c))
                    sudoku.add((c, j))
                    sudoku.add((i/3, j/3, c))
                    if self.SetSudokuNum(sudoku, board, i, j+1):
                        return True
                board[i][j] = '.'
                sudoku.remove((i, c))
                sudoku.remove((c, j))
                sudoku.remove((i/3, j/3, c))
        else:
            return self.SetSudokuNum(sudoku, board, i, j+1)
        return False
