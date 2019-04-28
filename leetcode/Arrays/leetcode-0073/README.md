## 73. Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
```
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```
Example 2:
```
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
```
Follow up:
* A straight forward solution using O(mn) space is probably a bad idea.
* A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

#### solution
用原数组的第一行第一列来记录各行各列是否有0.

* 先扫描第一行第一列，如果有0，则将各自的flag设置为true
* 然后扫描除去第一行第一列的整个数组，如果有0，则将对应的第一行和第一列的数字赋0
* 再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0
* 最后根据第一行第一列的flag来更新第一行第一列