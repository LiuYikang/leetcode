class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> ht = new HashMap<>();
        ht.put('I', 1);
        ht.put('V', 5);
        ht.put('X', 10);
        ht.put('L', 50);
        ht.put('C', 100);
        ht.put('D', 500);
        ht.put('M', 1000);
        int res = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = ht.get(s.charAt(i));
            if (tmp > pre) {
                res -= pre * 2;
            }
            res += tmp;
            pre = tmp;
        }
        return res;
    }
}