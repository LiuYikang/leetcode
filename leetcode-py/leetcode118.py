class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        ans = []
        for i in range(numRows):
            tmp = []
            if i == 0:
                tmp.append(1)
            else:
                for j in range(i+1):
                    if j == 0:
                        tmp.append(ans[i-1][0])
                    elif j == i:
                        tmp.append(ans[i-1][i-1])
                    else:
                        tmp.append(ans[i-1][j] + ans[i-1][j-1])
            ans.append(tmp[:])
        return ans
