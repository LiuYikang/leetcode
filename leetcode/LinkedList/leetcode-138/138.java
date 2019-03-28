/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node res = new Node(0, head, null);
        Map<Node, Node> map = new HashMap<>();

        Node node = head, pre = res;
        while (node != null) {
            Node tmp = new Node(node.val, null, null);
            pre.next = tmp;
            pre = pre.next;
            map.put(node, tmp);
            node = node.next;
        }

        node = head;
        pre = res.next;
        while (node != null) {
            pre.random = map.get(node.random);
            node = node.next;
            pre = pre.next;
        }
        return res.next;
    }
}