class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if not nums:
            return []
        i, j = 0, 1
        ans = []
        ran = []
        ran.append(str(nums[0]))
        while j < len(nums):
            if nums[j] - nums[i] > 1:
                if len(ran) > 1:
                    ans.append(str(ran[0]) + "->" + str(ran[1]))
                else:
                    ans.append(str(ran[0]))
                ran = [str(nums[j])]
            else:
                if len(ran) > 1:
                    ran[-1] = str(nums[j])
                else:
                    ran.append(str(nums[j]))
            i, j = j, j+1
        if len(ran) > 1:
            ans.append(str(ran[0]) + "->" + str(ran[1]))
        else:
            ans.append(str(ran[0]))
        return ans
