class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = []
        tmp = 1
        zeroFlag = 0
        for item in nums:
            if item != 0:
                tmp *= item
            if item == 0:
                zeroFlag += 1
        if zeroFlag > 1:
            return [0]*len(nums)
        for i in range(len(nums)):
            if nums[i] == 0:
                ans.append(tmp)
            else:
                if zeroFlag == 1:
                    ans.append(0)
                else:
                    ans.append(tmp / nums[i])
        return ans

class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l = len(nums)
        ans = []
        for i in range(1, l):
            ans.append(ans[i-1] * nums[i-1])
        right = 1
        for i in range(l-1, -1, -1):
            ans[i] *= right
            right *= nums[i]
        return ans
