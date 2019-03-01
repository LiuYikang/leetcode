class Solution:
    # @param {string} digits
    # @return {string[]}
    def letterCombinations(self, digits):
    	if 0 == len(digits):
    		return []
    	self.digits = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    	self.ans, tmp = [], []
    	self.dfs(digits, 0, tmp)
    	return self.ans


    def dfs(self, digits, index, tmp):
    	if index == len(digits):
    		self.ans.append(''.join(tmp))
    		return
    	for item in self.digits[ord(digits[index]) - ord('0')]:
    		tmp.append(item)
    		self.dfs(digits, index + 1, tmp)
    		tmp.pop()