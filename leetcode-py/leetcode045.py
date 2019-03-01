class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # numlen = len(nums)
        # jumpTime = [-1] * numlen
        # jumpTime[0] = 0
        # for i in range(numlen):
        #     for j in range(1, nums[i]+1):
        #         if i + j < numlen:
        #             if jumpTime[i+j] == -1:
        #                 jumpTime[i+j] = jumpTime[i] + 1
        #             else:
        #                 jumpTime[i+j] = min(jumpTime[i]+1, jumpTime[i+j])
        #         else:
        #             break
        # return jumpTime[numlen-1]
        maxJump, maxOffset, jumpTime = 0, 0, 0
        for i in range(len(nums)-1):
            maxOffset = max(maxOffset, nums[i]+i)
            if i == maxJump:
                maxJump, jumpTime = maxOffset, jumpTime+1
            print maxJump, maxOffset, jumpTime
        return jumpTime
