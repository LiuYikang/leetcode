/*The question requires us to make sure a child with a higher rate has more candies than its left and right neighbors. 
One simple solution is to do two scans: 
one foward scan (from 1 to N-1) to make sure child i has more candies than its left neighbor if its rate is higher than its left neighbor.
 After the forward scan, we can guarantee that the left neighbor relationship is correct but we have to do more to make the right neighbor relationship in order; 
 so we do the backwarad scan (from N-2 to 0) to make child i has more candies than its right neighbor i+1 if its rate is higher than its right neighbor. 
 In the following implementation, we need a O(N) array number to save the number of candies needed for children, 
 so it has O(N) space complexity and we do two linear scans so the time complexity is O(N)*/

class Solution {
public:
    int candy(vector<int>& ratings) {
        int childLen = ratings.size();
        int total = 0, i = 0;
        if (childLen == 0)
        {
            return total;
        }
        vector<int> num(childLen, 0);
        num[0] = 1;
        for (i = 1; i < childLen; i++)
        {
            num[i] = ratings[i] > ratings[i-1] ? num[i-1] + 1: 1;
        }
        total += num[childLen - 1];
        for (i = childLen - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i+1])
            {
                if (num[i] <= num[i+1])
                {
                    num[i] = num[i+1] + 1;
                }
            }
            total += num[i];
        }
        return total;
    }
};


