class Solution:
    # @param {string} s
    # @return {integer}
    def longestValidParentheses(self, s):
        stack = []
        vaildP = 0
        start = -1
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            elif s[i] == ')':
                if not stack:
                    start = i
                else:
                    stack.pop()
                    tmp = i-start if not stack else i-stack[len(stack)-1]
                    if tmp > vaildP:
                        vaildP = tmp
        return vaildP
