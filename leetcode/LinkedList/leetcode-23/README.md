## 23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
```
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

#### solution
使用一个k大小的最小堆，来每次取出k个链表里的最小值

也可以使用归并排序来实现