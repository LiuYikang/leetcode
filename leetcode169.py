class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count, ans = 1, nums[0]
        for i in range(1, len(nums)):
            if count == 0:
                ans = nums[i]
                count += 1
            else:
                if ans == nums[i]:
                    count += 1
                else:
                    count -= 1
        return ans
