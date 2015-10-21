class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        count = 0
        ans = []
        self.hash = [False] * len(nums)
        self.DFS(nums, count, ans, [])
        return ans

    def DFS(self, nums, count, ans, tmp):
        L = len(nums)
        if count == L:
            ans.append(tmp[:])
            return
        for i in range(len(nums)):
            if self.hash[i] is False:
                tmp.append(nums[i])
                self.hash[i] = True
                self.DFS(nums, count+1, ans, tmp)
                self.hash[i] = False
                tmp.remove(nums[i])
