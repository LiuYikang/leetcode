class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer}
    def threeSumClosest(self, nums, target):
        nums.sort()
        mySum, offset, ret = 0, 99999, 0
        for i in range(len(nums)):
            first, mid, last = i, i + 1, len(nums) - 1
            while mid < last:
                mySum = nums[first] + nums[mid] + nums[last]
                if offset > abs(mySum - target):
                    offset, ret = abs(mySum - target), mySum
                if mySum < target:
                    mid += 1
                elif mySum > target:
                    last -= 1
                else:
                    return mySum
        return ret
