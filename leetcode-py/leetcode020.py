class Solution:
    # @param {string} s
    # @return {boolean}
    def isValid(self, s):
        stack = []
        for item in s:
        	if item == '(' or item == '[' or item == '{':
        		stack.append(item)
        	elif item == ')' and len(stack) and stack[-1] == '(':
        		stack.pop()
        	elif item == ']' and len(stack) and stack[-1] == '[':
        		stack.pop()
        	elif item == '}' and len(stack) and stack[-1] == '{':
        		stack.pop()
        	else:
        		return False
        if not stack:
        	return True
        else:
        	return False
