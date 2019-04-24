class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {        
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval != null && interval[0] >= newInterval[0]) {
                list.add(newInterval);
                newInterval = null;
            }
            list.add(interval);
        }
        if (newInterval != null) {
            list.add(newInterval);
        }

        List<int[]> res = new ArrayList<>();
        int[] tmp = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (tmp[1] >= list.get(i)[0]) {
                tmp[1] = Math.max(tmp[1], list.get(i)[1]);
            } else {
                res.add(tmp);
                tmp = list.get(i);
            }
        }
        res.add(tmp);

        int[][] ret = new int[res.size()][];
        int j = 0;
        for (int[] r : res) {
            ret[j++] = r;
        }
        return ret;
    }
}