class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        ans = [1]
        for i in range(2, rowIndex+1):
            tmp = ans[i-1] * (rowIndex-i) / (i + 1)
            ans.append(tmp)
        return ans
