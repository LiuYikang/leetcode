class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        i = 0
        while i < l:
            if nums[i] == -1 or nums[i] >= l:
                i += 1
            else:
                index = nums[i]
                while index < l and nums[index] != -1:
                    tmp = nums[index]
                    nums[index] = -1
                    if tmp != index:
                        index = tmp
                    else:
                        break
                i += 1
        for i in range(l):
            if nums[i] != -1:
                return i
        return l
