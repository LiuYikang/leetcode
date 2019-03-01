# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        pre, rear = 1, n
        while pre < rear:
            mid = (pre + rear) / 2
            if self.isBadVersion(mid):
                rear = mid - 1
            else:
                pre = mid + 1
        return pre
