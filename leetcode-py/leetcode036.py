class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        Sudoku = set()
        for i in range(9):
            for j in range(9):
                if board[i][j] is not '.':
                    num = board[i][j]
                    if (i, num) in Sudoku or (num, j) in Sudoku or (i/3, j/3, num) in Sudoku:
                        return False
                    Sudoku.add((i, num))
                    Sudoku.add((num, j))
                    Sudoku.add((i/3, j/3, num))
        return True
