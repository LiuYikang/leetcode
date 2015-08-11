class Solution:
    # @param {string} s
    # @param {string[]} words
    # @return {integer[]}
    def findSubstring(self, s, words):
        if not s or not words or not words[0]:
            return []

        wordDic, sDic = {}, {}
        for item in words:
            if item not in wordDic.keys():
                wordDic[item] = 1
            else:
                wordDic[item] += 1

        ret = []
        wordLen = len(words[0])
        sLen = len(s)
        for i in range(wordLen):
            left = i
            count = 0
            sDic.clear()
            for j in range(i, sLen, wordLen):
                word = s[j:j+wordLen]

                if word in wordDic.keys():
                    if word not in sDic.keys():
                        sDic[word] = 1
                    else:
                        sDic[word] += 1
                    if sDic[word] <= wordDic[word]:
                        count += 1
                    else:
                        while s[left:left+wordLen] != word:
                            tmpWord = s[left:left+wordLen]
                            sDic[tmpWord] -= 1
                            if sDic[tmpWord] == 0:
                                del sDic[tmpWord]
                            count -= 1
                            left += wordLen
                        left += wordLen
                        sDic[word] -= 1
                else:
                    sDic.clear()
                    count = 0
                    left = j + wordLen

                if count == len(words):
                    ret.append(left)
                    sDic[s[left:left+wordLen]] -= 1
                    if sDic[s[left:left+wordLen]] == 0:
                        del sDic[s[left:left+wordLen]]
                    left += wordLen
                    count -= 1

        return ret
