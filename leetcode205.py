class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        ls, lt = len(s), len(t)
        if ls != lt:
            return False
        count = 1
        sMap = {}
        tMap = {}
        for i in range(ls):
            if not sMap.has_key(s[i]) and not tMap.has_key(t[i]):
                sMap[s[i]] = count
                tMap[t[i]] = count
                count += 1
            elif not sMap.has_key(s[i]) or not tMap.has_key(t[i]):
                return False
            else:
                if sMap[s[i]] == tMap[t[i]]:
                    sMap[s[i]] = count
                    tMap[t[i]] = count
                    count += 1
                else:
                    return False
        return True
