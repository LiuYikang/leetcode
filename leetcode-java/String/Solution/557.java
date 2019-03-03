/**
557. Reverse Words in a String III

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
**/
class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }

        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(reverse(ss[i]));
        }
        return sb.toString();
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
