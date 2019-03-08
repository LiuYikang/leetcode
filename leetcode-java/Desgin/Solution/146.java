/**
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

思路：
双向链表实现
**/

class ListNode {
    int val;
    int key;
    ListNode next;
    ListNode pre;
    
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.pre = null;
    }
    
    public ListNode() {
        this.key = 0;
        this.val = 0;
        this.next = null;
        this.pre = null;
    }
}

class LRUCache {
    Map<Integer, ListNode> list;
    int capacity;
    int count;
    ListNode head;
    ListNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.list = new HashMap<>();
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }
    
    public int get(int key) {
        if (!list.containsKey(key)) {
            return -1;
        } else {
            ListNode node = this.list.get(key);
            this.remove(node);
            this.add(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }
        if (!this.list.containsKey(key)) {
            ListNode node = new ListNode(key, value);
            this.list.put(key, node);
            this.add(node);
            this.count++;
            if (this.count > this.capacity) {
                ListNode toDelete = this.tail.pre;
                this.remove(toDelete);
                this.list.remove(toDelete.key);
                this.count--;
            }
        } else {
            ListNode node = this.list.get(key);
            node.val = value;
            this.remove(node);
            this.add(node);
        }
    }
    
    private void add(ListNode node) {
        node.next = this.head.next;
        this.head.next.pre = node;
        node.pre = this.head;
        this.head.next = node;
    }
    
    private void remove(ListNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
