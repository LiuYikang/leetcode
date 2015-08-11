class Solution:
    # @param {string} haystack
    # @param {string} needle
    # @return {integer}
    def strStr(self, haystack, needle):
        if not needle:
            return 0
        next = self.getNext(needle)
        i, j = 0, 0
        hLen = len(haystack)
        nLen = len(needle)
        while i < hLen and j < nLen:
            if j == -1 or haystack[i] == needle[j]:
                i += 1
                j += 1
            else:
                j = next[j]
        if j == nLen:
            return i - j
        else:
            return -1

    def getNext(self, p):
        next = []
        next.append(-1)
        pLen = len(p)
        k, j = -1, 0
        while j < pLen-1:
            if k == -1 or p[j] == p[k]:
                j += 1
                k += 1
                next.append(k)
            else:
                k = next[k]
        return next
