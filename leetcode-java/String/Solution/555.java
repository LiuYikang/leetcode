/**
555.Split Concatenated Strings
Given a list of strings, you could concatenate these strings together into a loop, where for each string you could choose to reverse it or not. Among all the possible loops, you need to find the lexicographically biggest string after cutting the loop, which will make the looped string into a regular one.

Specifically, to find the lexicographically biggest string, you need to experience two phases:

Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
Cut and make one breakpoint in any place of the loop, which will make the looped string into a regular one starting from the character at the cutpoint.
And your job is to find the lexicographically biggest one among all the possible regular strings.

Example:
Input: "abc", "xyz"
Output: "zyxcba"
Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
where '-' represents the looped status.
The answer string came from the fourth looped one,
where you could cut from the middle character 'a' and get "zyxcba".
Note:
The input strings will only contain lowercase letters.
The total length of all the strings will not over 1,000.


解法：首先将所有的字符串都处理成字典序最大的（反向或者不反向），然后连接起来。接着遍历每个字符串，试图将它以及它的reverse从每个位置切开，并测试形成的regular字符串，一旦发现其字典序大于当前的最大值，则更新当前最大值。最后返回最大值即可。

首先将res初始化为“a”，即为字典序中最小的字符串。而在测试切开位置的过程中，只有在p1[j]或者p2[j]大于res[0]的时候才更新res，这样就可以减少冗余的字符串拼接操作，从而提高运行效率。

第一步，处理原字符串，如果strs[i].reverse > strs[i], 则strs[i] = strs[i].reverse. 可以确保mid string是最优的

第二步，对于一个string array，比如 "abc", "def", "xyz", 先生成一个mid string，mid string没有最后一个string，比如"abcdef". 然后update mid string:

mid = mid.substr(str.length()) + strs[(i+n-1) % n];
这样mid string就变成 defxyz(由abcdef，去掉abc，加上xyz)，xyzabc.

然后扫原string array中的每一个string，生成相应的截取result。比如对于abc，我们有mid string = defxyz, 所以组合是：
正序：abc-defxyz, bc-defxyz-a, c-defxyz-ab, defxyz-abc
反序：cba-defxyz, ba-defxyz-c, a-defxyz-cb, defxyz-cba,
然后所有循环中挑出全局最大的.
**/
public class Solution {
    /**
     * @param strs: a list of string
     * @return: return a string
     */
    public String splitLoopedString(List<String> strs) {
        for (int i = 0; i < strs.size(); i++) {
            String rev = new StringBuilder(strs.get(i)).reverse().toString();
            if (rev.compareTo(strs.get(i)) > 0) {
                strs.set(i, rev);
            }
        }

        String res = "a";

        for (int i = 0; i < strs.size(); i++) {
            String rev = new StringBuilder(strs.get(i)).reverse().toString();
            for (String s : new String[]{strs.get(i), rev}) {
                for (int k = 0; k < s.length(); k++) {
                    StringBuilder sb = new StringBuilder(s.substring(k));
                    for (int j = i + 1; j < strs.size(); j++) {
                        sb.append(strs.get(j));
                    }
                    for (int j = 0; j < i; j++) {
                        sb.append(strs.get(j));
                    }
                    sb.append(s.substring(0, k));

                    if (sb.charAt(0) >= res.charAt(0) && sb.toString().compareTo(res) > 0) {
                        res = sb.toString();
                    }
                }
            }
        }
        return res;
    }
}
