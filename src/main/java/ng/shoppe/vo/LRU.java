package ng.shoppe.vo;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    class Node{
        Integer key;
        Integer val;
        Node pre;
        Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    Integer capacity;
    Node head;
    Node tail;
    Map<Integer,Node> nodeMap ;
    public LRU(int capacity){
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key , int val){
        Node node = new Node(key,val);
        if(nodeMap.containsKey(key)){
            removeNode(nodeMap.get(key));
        }else {
            if(capacity == nodeMap.size()){
                removeNode(tail.pre);
            }
            moveToHead(node);
            nodeMap.put(key,node);
        }
    }

    public Integer get(int key){
        Node node = nodeMap.get(key);
        if(node == null){
            return null;
        }
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        nodeMap.remove(node.key);
    }
}
