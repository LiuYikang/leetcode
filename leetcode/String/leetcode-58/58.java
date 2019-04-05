class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            res++;
            i--;
        }
        return res;
    }
}