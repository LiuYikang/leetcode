class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j++));
            res = Math.max(res, j - i);
        }
        return res;
    }
}