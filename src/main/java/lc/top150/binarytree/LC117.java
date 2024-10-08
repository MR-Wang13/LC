package lc.top150.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class LC117 {
    public static Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node pre = new Node();
        pre.next = root;
        Deque<Node> stack  = new LinkedList<>();
        stack.push(root);
        Deque<Node> list  = new LinkedList<>();
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            list.push(cur);
            while (!stack.isEmpty()){
                Node next = stack.pop();
                list.push(next);
                cur.next  = next;
                cur = next;
            }
            while (!list.isEmpty()){
                Node n = list.pop();
                if (n.right!=null){
                    stack.push(n.right);
                }
                if (n.left!=null){
                    stack.push(n.left);
                }
            }
        }

        return pre.next;
    }

    public static void main(String[] args) {

        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node3 = new Node(3);
        node3.right = node7;
        Node node2 = new Node(2,node4,node5,null);

        Node node1 = new Node(1,node2,node3,null);
        connect(node1);

    }
    }

