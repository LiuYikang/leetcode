class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def search(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + ((high-low) >> 1)
            if nums[mid] == target:
                return mid
            elif nums[mid] > nums[low] and target < nums[mid] and target >= nums[low]:
                high = mid - 1
            elif nums[mid] < nums[low] and (target >= nums[low] or target < nums[mid]):
                high = mid - 1
            else:
                low = mid + 1
        return -1
