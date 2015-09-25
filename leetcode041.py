class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l == 0:
            return 1
        i = 0
        while i < l:
            if nums[i] != '' and nums[i] - 1 < l:
                index = nums[i] - 1
                while 0 <= index < l and nums[index] != '':
                    tmp = nums[index] - 1
                    nums[index] = ''
                    if tmp != index:
                        index = tmp
                    else:
                        break
            i += 1
        for i in range(l):
            if nums[i] != '':
                return i + 1
        return l + 1
