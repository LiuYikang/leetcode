class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dic = {}
        ls, lt = len(s), len(t)
        if ls != lt:
            return False
        # for item in s:
        #     if item in dic.keys():
        #         dic[item] += 1
        #     else:
        #         dic[item] = 1
        # for item in t:
        #     if dic[item] == 0:
        #         return False
        #     dic[item] -= 1
        # return True
        for i in range(ls):
            if not s[i] in dic.keys():
                dic[s[i]] = 0
            if not t[i] in dic.keys():
                dic[t[i]] = 0
            dic[s[i]] += 1
            dic[t[i]] -= 1
        for item in dic.keys():
            if dic[item] != 0:
                return False
        return True
