class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        lHigh = []
        rHigh = []
        total = high = 0
        l = len(height)
        for item in height:
            if item > high:
                high = item
            lHigh.append(high)
        high = 0
        for i in range(l-1, -1, -1):
            if height[i] > high:
                high = height[i]
            rHigh.append(high)
        for i in range(l):
            tmp = min(lHigh[i], rHigh[l-i-1]) - height[i]
            total += tmp if tmp > 0 else 0
        return total
