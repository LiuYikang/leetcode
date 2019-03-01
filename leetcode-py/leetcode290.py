class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        strList = str.split(' ')
        lp, ls = len(pattern), len(strList)
        if lp != ls:
            return False
        strDic = {}
        for i in range(lp):
            if pattern[i] not in strDic.keys() and strList[i] not in strDic.values():
                strDic[pattern[i]] = strList[i]
            if pattern[i] in strDic.keys():
                if strDic[pattern[i]] != strList[i]:
                    return False
            else:
                return False
        return True
