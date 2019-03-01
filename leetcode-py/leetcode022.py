class Solution:
    # @param {integer} n
    # @return {string[]}
    def generateParenthesis(self, n):
        if not n:
            return []
        Lparent, Rparent, ans = n, n, []
        self.dfs(Lparent, Rparent, ans, "")
        return ans

    def dfs(self, Lparent, Rparent, ans, ansTmp):
        if Rparent < Lparent:
            return
        if not Rparent and not Lparent:
            ans.append(ansTmp)
            return
        if Lparent:
            self.dfs(Lparent - 1, Rparent, ans, ansTmp + '(')
        if Rparent:
            self.dfs(Lparent, Rparent - 1, ans, ansTmp + ')')
