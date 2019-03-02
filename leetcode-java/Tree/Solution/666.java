/**
666.Path Sum IV
If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation:
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:
Input: [113, 221]
Output: 4
Explanation:
The tree that the list represents is:
    3
     \
      1

The path sum is (3 + 1) = 4.

这道题还是让我们求二叉树的路径之和，但是跟之前不同的是，树的存储方式比较特别，并没有专门的数结点，而是使用一个三位数字来存的，百位数是该结点的深度，十位上是该结点在某一层中的位置，个位数是该结点的结点值。为了求路径之和，我们肯定还是需要遍历树，但是由于没有树结点，所以我们可以用其他的数据结构代替。比如我们可以将每个结点的位置信息和结点值分离开，然后建立两者之间的映射。比如我们可以将百位数和十位数当作key，将个位数当作value，建立映射。由于题目中说了数组是有序的，所以首元素就是根结点，然后我们进行先序遍历即可。在递归函数中，我们先将深度和位置拆分出来，然后算出左右子结点的深度和位置的两位数，我们还要维护一个变量cur，用来保存当前路径之和。如果当前结点的左右子结点不存在，说明此时cur已经是一条完整的路径之和了，加到结果res中，直接返回。否则就是对存在的左右子结点调用递归函数即可.
**/
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: return an integer
     */
     int res = 0;

     public int pathSum(int[] nums) {
         if (nums.length == 0) {
             return 0;
         }

         HashMap<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < nums.length; i++) {
             map.put(nums[i] / 10, nums[i] % 10);
         }
         helper(nums[0] / 10, 0, 0, map);

         return res;
     }

     public void helper(int idx, int ret, int cur, HashMap<Integer, Integer> map) {
         int left = (idx / 10 + 1) * 10 + (idx % 10) * 2 - 1;
         int right = (idx / 10 + 1) * 10 + (idx % 10) * 2;
         cur += map.get(idx);

         if(!map.containsKey(left) && !map.containsKey(right)) {
             ret += cur;
             res += ret;
             return;
         }
         if(map.containsKey(left)) {
             helper(left, ret, cur, map);
         }
         if(map.containsKey(right)) {
             helper(right, ret, cur, map);
         }
     }
}
