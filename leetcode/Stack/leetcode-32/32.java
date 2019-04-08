class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int start = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    int tmp = stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}