class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[]}
    def searchRange(self, nums, target):
        start = end = -1
        low, high = 0, len(nums)-1
        if target < nums[low] or target > nums[high]:
            return [start, end]
        while low <= high:
            mid = low + ((high-low) >> 1)
            print low, high, mid
            if nums[mid] == target:
                start = low + self.searchStart(nums[low:mid+1], target)
                end = mid + self.searchEnd(nums[mid:high+1], target)
                break
            elif nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
        return [start, end]

    def searchStart(self, nums, target):
        low, high = 0, len(nums)-1
        start = -1
        while low <= high:
            mid = low + ((high-low) >> 1)
            if nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            elif nums[mid] == target:
                start = mid
                high = mid - 1
        return start

    def searchEnd(self, nums, target):
        low, high = 0, len(nums)-1
        end = -1
        while low <= high:
            mid = low + ((high-low) >> 1)
            if nums[mid] < target:
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            elif nums[mid] == target:
                end = mid
                low = mid + 1
        return end
