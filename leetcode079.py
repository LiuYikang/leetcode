class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.success = False
        self.col = len(board[0])
        self.row = len(board)
        self.l = len(word)
        s = []
        if self.l <= 0:
            return False
        self.mark = [[0 for i in range(self.col)] for j in range(self.row)]
        self.go = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for i in range(self.row):
            for j in range(self.col):
                if board[i][j] == word[0]:
                    s.append([i, j])
        if len(s) is not 0:
            if self.l == 1:
                self.success = True
            for i in range(len(s)):
                self.mark[s[i][0]][s[i][1]] = -1
                self.DFS(s[i][0], s[i][1], 1, board, word)
                self.mark[s[i][0]][s[i][1]] = 0
                if self.success is True:
                    break
        return self.success

    def DFS(self, x, y, c, board, word):
        if c >= self.l:
            return
        for i in range(4):
            nx = x + self.go[i][0]
            ny = y + self.go[i][1]
            if nx < 0 or nx >= self.row or ny < 0 or ny >= self.col:
                continue
            if self.mark[nx][ny] == -1:
                continue
            if board[nx][ny] == word[c]:
                if c + 1 == self.l:
                    self.success = True
                    return
                self.mark[nx][ny] = -1
                self.DFS(nx, ny, c+1, board, word)
                self.mark[nx][ny] = 0
            if self.success:
                return
