class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 0:
            return False
        testNum = num
        while testNum % 2 == 0:
            testNum /= 2
        while testNum % 3 == 0:
            testNum /= 3
        while testNum % 5 == 0:
            testNum /= 5
        if testNum != 1:
            return False
        return True
