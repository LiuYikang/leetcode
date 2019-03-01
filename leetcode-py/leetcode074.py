#Binary Search
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
            return False
        m, n = len(matrix), len(matrix[0])
        rowLow, rowHigh = 0, m-1
        colLow, colHigh = 0, n-1
        while rowLow < rowHigh:
            rowMid = (rowLow + rowHigh) / 2
            if target < matrix[rowMid][0]:
                rowHigh = rowMid - 1
            if target > matrix[rowMid][n-1]:
                rowLow = rowMid + 1
            if target >= matrix[rowMid][0] and target <= matrix[rowMid][n-1]:
                rowLow = rowMid
                break
        while colLow < colHigh:
            colMid = (colLow + colHigh) / 2
            if target < matrix[rowLow][colMid]:
                colHigh = colMid - 1
            if target > matrix[rowLow][colMid]:
                colLow = colMid + 1
            if target == matrix[rowLow][colMid]:
                return True
        return True if target == matrix[rowLow][colLow] else False
