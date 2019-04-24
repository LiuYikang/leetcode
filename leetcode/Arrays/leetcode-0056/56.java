class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<Integer> list = new ArrayList<>();

        int end = intervals[0][1];
        list.add(intervals[0][0]);
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(end);
                list.add(intervals[i][0]);
                end = intervals[i][1];
            }
        }
        list.add(end);
        list.add(intervals[intervals.length - 1][0]);
        int[][] res = new int[list.size() / 2][2];
        int i = 0, j = 0;
        while (i < list.size() && j < list.size() / 2) {
            res[j][0] = list.get(i++);
            res[j][1] = list.get(i++);
            j++;
        }
        return res;
    }
}