class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i, j = 0, 0
        l = len(nums)
        while j < l:
            if not nums[j]:
                i = j + 1
                flag = 1
                while i < l:
                    if nums[i]:
                        nums[i], nums[j] = nums[j], nums[i]
                        flag = 0
                        break
                    i += 1
            if flag:
                break
            j += 1
