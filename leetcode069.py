class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        low, high = 0, x
        while low < high:
            mid = (low + high) / 2
            if mid*mid == x:
                low = mid
                break
            if (mid+1)*(mid+1) <= x:
                low = mid+1
            if mid*mid > x:
                high = mid
            if mid*mid < x and (mid+1)*(mid+1) > x:
                low = mid
                break
        return low
