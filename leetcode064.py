class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return 0
        m, n = len(grid), len(grid[0])
        path = [[10000 for i in range(n+1)] for j in range(m+1)]
        path[1][1] = grid[0][0]
        for i in range(1, m+1):
            for j in range(1, n+1):
                if i == 1 and j == 1:
                    continue
                path[i][j] = min(path[i-1][j] + grid[i-1][j-1], path[i][j-1] + grid[i-1][j-1])
        return path[m][n]
