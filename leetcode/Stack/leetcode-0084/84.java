import java.util.Arrays;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int i = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] h = new int[heights.length + 1];
        h = Arrays.copyOf(heights, heights.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int tmp = stack.pop();
                res = Math.max(res, h[tmp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return res;
    }
}