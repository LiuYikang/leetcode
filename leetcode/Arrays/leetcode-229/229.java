class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int target1, target2;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == target1) {
                count1++;
            } else if (num == target2) {
                count2++;
            } else if (count1 == 0) {
                target1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                target2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == target1) {
                count1++;
            } else if (num == target2) {
                count2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) {
            res.add(target1);
        }
        if (count2 > nums.length / 3) {
            res.add(target2);
        }
        return res;
    }
}