class Solution:
    # @param {string} s
    # @return {string}
    def longestPalindrome(self, s):
        arr = ['$', '#']
        for i in range(len(s)):
            arr.append(s[i])
            arr.append('#')
        p = [0 for i in range(len(arr))]
        mx, mid, ansp = 0, 0, 0
        for i in range(1, len(arr)):
            p[i] = min(p[2 * mid - i], mx - i) if mx > i else 1
            while i + p[i] < len(arr) and i - p[i] >= 0 and arr[i + p[i]] == arr[i - p[i]]: 
                p[i] += 1
            if i + p[i] > mx:
                mx = i + p[i]
                mid = i
            if p[i] > p[ansp]:
                ansp = i
        start = (ansp - p[ansp] + 1) / 2
        return s[start : start + p[ansp] - 1]
