/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        copyNode(node, map);
        if (node.neighbors != null) {
            copyNeighbor(node, map);
        }
        return map.get(node);
    }

    private void copyNode(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return;
        }
        Node copyNode = new Node(node.val, null);
        map.put(node, copyNode);
        for (int i = 0; i < node.neighbors.size(); i++) {
            copyNode(node.neighbors.get(i), map);
        }
    }

    private void copyNeighbor(Node node, Map<Node, Node> map) {
        if (map.get(node).neighbors != null) {
            return;
        }
        List<Node> nei = new ArrayList<>();
        for (int i = 0; i < node.neighbors.size(); i++) {
            nei.add(map.get(node.neighbors.get(i)));
        }
        map.get(node).neighbors = nei;

        for (int i = 0; i < node.neighbors.size(); i++) {
            copyNeighbor(node.neighbors.get(i), map);
        }
    }
}