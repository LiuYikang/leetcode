class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        helper(res, letters, "", digits, 0);
        return res;
    }

    private void helper(List<String> res, String[] letters, String str, String digits, int i) {
        if (i == digits.length()) {
            res.add(str);
            return;
        }

        String letter = letters[digits.charAt(i) - '0'];
        for (int j = 0; j < letter.length(); j++) {
            helper(res, letters, str + letter.charAt(j), digits, i + 1);
        }
    }
}