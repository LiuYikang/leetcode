class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        self.ret = []
        ans = []
        self.helper(candidates, target, 0, 0, ans)
        return self.ret

    def helper(self, candidates, target, loc, s, ans):
        if s == target:
            if ans not in self.ret:
                self.ret.append(ans[:])
            return
        for i in range(loc, len(candidates)):
            s += candidates[i]
            ans.append(candidates[i])
            if s <= target:
                self.helper(candidates, target, i+1, s, ans)
            s -= candidates[i]
            ans.pop()
