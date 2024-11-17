package ng.meta;

import java.util.*;

public class LC133 {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node,map);
    }

    private static Node dfs(Node node, HashMap<Integer, Node> map) {
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        node.neighbors.forEach(item -> {
            newNode.neighbors.add(dfs(item, map));
        });

        return newNode;
    }

    public static Node cloneGraphNFS(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node.val, new Node(node.val));
        Node head = null;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            Node clone = map.get(cur.val);

            if(head == null){
                head = clone;
            }
            for(Node n : cur.neighbors){
                if(!map.containsKey(n.val)){
                    Node newNode = new Node(n.val);
                    map.put(n.val, newNode);
                    queue.add(n);
                }

                clone.neighbors.add(map.get(n.val));
            }

        }
        return head;
    }
}
