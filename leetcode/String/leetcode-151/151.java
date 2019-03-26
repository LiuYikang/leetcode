class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i++) {
            if (!strs[i].equals("")) {
                res.append(strs[i]).append(" ");
            }
        }
        return res.length() == 0 ? "" : res.toString().trim();
    }
}