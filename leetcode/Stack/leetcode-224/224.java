class Solution {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        int res = 0;

        int sigh = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sigh * num;
                i--;
            } else if (s.charAt(i) == '+') {
                sigh = 1;
            } else if (s.charAt(i) == '-') {
                sigh = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sigh);
                res = 0;
                sigh = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            } else {
                continue;
            }
        }
        return res;
    }
}