class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        maxAns, tmpmax, tmpmin = nums[0], nums[0], nums[0]
        for item in nums[1:]:
            tmpX, tmpY = tmpmax, tmpmin
            tmpmax = max(item, item * tmpX, item * tmpY)
            tmpmin = min(item, item * tmpX, item * tmpY)
            if tmpmax > maxAns:
                maxAns = tmpmax
        return maxAns
