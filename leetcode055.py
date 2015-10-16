class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # L = len(nums)
        # if L == 1:
        #     return True
        # loc = offset = 0
        # maxOffset = nums[loc]
        # for offset in range(1, maxOffset+1):
        #     if loc + offset < L:
        #         if self.canJump(nums[loc+offset:]):
        #             return True
        #     else:
        #         break
        # return False
        #
        maxOffset = nums[0]
        for i in range(1, len(nums)):
            maxOffset -= 1
            if maxOffset < 0:
                return False
            maxOffset = max(maxOffset, nums[i])
        return True
