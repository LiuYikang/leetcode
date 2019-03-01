class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def removeDuplicates(self, nums):
        if len(nums) == 0:
            return 0
        i = 0
        for j in range(len(nums)):
            if nums[j] != nums[i]:
                i += 1
                nums[i] = nums[j]
            else:
                continue
        return i + 1