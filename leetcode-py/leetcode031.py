class Solution:
    # @param {integer[]} nums
    # @return {void} Do not return anything, modify nums in-place instead.
    def nextPermutation(self, nums):
        loc = 0
        for i in range(len(nums)-1, 0, -1):
            if nums[i] > nums[i-1]:
                loc = i
                break
        print loc
        if loc is 0:
            nums = sorted(nums)
        elif loc is not 0:
            for j in range(len(nums)-1, loc-1, -1):
                if nums[j] > nums[loc-1]:
                    tmp = nums[j]
                    nums[j] = nums[loc-1]
                    nums[loc-1] = tmp
                    break
            nums[loc:] = sorted(nums[loc:])
        print nums
