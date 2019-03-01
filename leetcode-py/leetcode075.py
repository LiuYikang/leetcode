class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        l = len(nums)
        low, high = 0, l-1
        i = 0
        while i <= high and low < high:
            if nums[i] == 0:
                nums[i], nums[low] = nums[low], nums[i]
                low += 1
                i += 1
            elif nums[i] == 2:
                nums[i], nums[high] = nums[high], nums[i]
                high -= 1
            else:
                i += 1

   