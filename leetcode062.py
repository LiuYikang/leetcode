#O(m*n) space
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m == 0 or n == 0:
            return 0
        grid = [[0 for i in range(n+1)] for j in range(m+1)]
        grid[1][1] = 1
        for i in range(1,m+1):
            for j in range(1, n+1):
                grid[i][j] += grid[i-1][j] + grid[i][j-1]
        return grid[m][n]

#O(n) space
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m == 0 or n == 0:
            return 0
        grid = [1 for i in range(n)]
        for i in xrange(1, m):
            for j in xrange(1, n):
                grid[j] += grid[j-1]
        return grid[n-1]
