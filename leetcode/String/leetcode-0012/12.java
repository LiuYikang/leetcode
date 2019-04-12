class Solution {
    public String intToRoman(int num) {
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman.length; i++) {
            while (num >= n[i]) {
                num -= n[i];
                res.append(roman[i]);
            }
        }
        return res.toString();
    }
}