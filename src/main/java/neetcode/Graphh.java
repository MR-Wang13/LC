package neetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Graphh {
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
            if (node == null) {
                return null;
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(node.val);
            return dfs(node, set);
        }

        public static Node dfs(Node node, HashSet<Integer> set) {

            Node newNode = new Node(node.val);
            List<Node> neighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                if (set.contains(neighbor.val)) {
                    continue;
                }
                set.add(neighbor.val);
                neighbors.add(dfs(neighbor, set));
            }
            newNode.neighbors = neighbors;

            return newNode;

        }

        public static void main(String[] args) {
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
            node2.neighbors.add(node3);
            node3.neighbors.add(node2);
            cloneGraph(node1);
        }

}
