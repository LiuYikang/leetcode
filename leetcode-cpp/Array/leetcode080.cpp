class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        int insertp = -1, readp = 0;
        int count = 0;
        while(readp < n)
        {
            if(count == 2)
            {
                if(nums[readp] == nums[insertp])
                {
                    readp++;
                    continue;
                }
                else
                {
                    count = 0;
                }
            }
            if(nums[readp] != nums[insertp])
            {
                count = 0;
            }
            nums[++insertp] = nums[readp++];
            count++;
        }
        return insertp+1;
    }
};