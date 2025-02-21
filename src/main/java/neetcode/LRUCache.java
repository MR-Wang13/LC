package neetcode;

import java.util.HashMap;

class LRUCache {

    Node head = new Node(-1);
    Node tail = new Node(-1);

    HashMap<Integer, Node> nodeMap = new HashMap();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.moveToTail(tail);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(nodeMap.size() >= capacity){
            head.next.remove();
        }
        Node node = new Node(value);
        nodeMap.put(key, node);
        node.moveToTail(tail);

    }

    class Node{
        int val;
        Node next;
        Node pre;
        Node(int val){
            this.val = val;
        }
        void remove(){
            this.pre.next = this.next;
            this.next.pre = this.pre;
        }
        void moveToTail(Node tail){
            tail.pre.next = this;
            this.pre = tail.pre;
            this.next = tail;
            tail.pre = this;
        }
    }
}


