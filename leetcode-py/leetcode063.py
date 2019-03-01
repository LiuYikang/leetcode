#dynamic program & O(n) space
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if not obstacleGrid:
            return 0
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        grid = [0 for i in range(n)]
        grid[0] = 1 if obstacleGrid[0][0] == 0 else 0
        for i in range(m):
            grid[0] = grid[0] if obstacleGrid[i][0] == 0 else 0
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    grid[j] = 0
                else:
                    grid[j] += grid[j-1]
        return grid[n-1]
            