class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def searchInsert(self, nums, target):
        if not nums or target < nums[0]:
            return 0
        if target > nums[len(nums) - 1]:
            return len(nums)
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + ((high-low) >> 1)
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                if nums[mid-1] < target:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                if nums[mid+1] > target:
                    return mid + 1
                else:
                    low = mid + 1
