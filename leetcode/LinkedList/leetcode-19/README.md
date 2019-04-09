## 19. Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head.

Example:
```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

#### solution
two point实现

第一个指针先走n步，然后第二个指针再同步走，当第一个指针走到最后时，第二个指针就是倒数第n个节点