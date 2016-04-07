class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int total = 0;
        int sum = 0;
        int start = 0;
        int n = gas.size();
        for (int i = 0; i < n; i++)
        {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0)
            {
                sum = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }
};