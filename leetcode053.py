#dynamic program O(n)
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxSubarray, tmpSubarray = nums[0], 0
        for item in nums:
            if tmpSubarray > 0:
                tmpSubarray += item
            else:
                tmpSubarray = item
            maxSubarray = max(maxSubarray, tmpSubarray)
        return maxSubarray

#divide and conquer O(nlogn)
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.maxArray(nums, 0, len(nums)-1)
        
    def maxArray(self, nums, left, right):
        if left > right:
            return 0
        if left == right:
            return nums[left]
        mid = (left+right) / 2

        lmax, lsum = nums[mid], 0
        for i in range(mid, left-1, -1):
            lsum += nums[i]
            if lsum > lmax:
                lmax = lsum
        
        rmax, rsum = nums[mid+1], 0
        for i in range(mid+1, right+1):
            rsum += nums[i]
            if rsum > rmax:
                rmax = rsum
        
        return max(lmax + rmax, self.maxArray(nums, left, mid), self.maxArray(nums, mid+1, right))
