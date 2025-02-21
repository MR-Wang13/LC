package neetcode;

import java.util.HashMap;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class LinkedListt {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseList(slow.next);
        ListNode first = head;
        while(first!= null && second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        first.next = second;
    }
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public Node copyRandomList(Node head) {
        HashMap<Integer, Node> map = new HashMap<>();
        Node dump = new Node(-1);
        Node newCur = dump;
        Node cur = head;
        while(cur!=null){
            Node node;
            Node random;
            Node next;
            if(map.containsKey(cur.val)){
                node = map.get(cur.val);
            }else{
                node = new Node(cur.val);
                map.put(cur.val, node);
            }
            if(cur.random!=null){
                if(map.containsKey(cur.random.val)){
                    random =  map.get(cur.random.val);
                }else{
                    random = new Node(cur.random.val);
                    map.put(cur.random.val, random);
                }
                node.random = random;

            }
            if(cur.next!=null){
                if(map.containsKey(cur.next.val)){
                    next =  map.get(cur.next.val);
                }else{
                    next = new Node(cur.next.val);
                    map.put(cur.next.val, next);
                }
                node.next = next;

            }
            newCur.next = node;
            newCur = newCur.next;
            cur = cur.next;
        }
        return dump.next;
    }
    public Node copyRandomListOp(Node head) {
        if (head == null) {
            return null;
        }

        Node l1 = head;
        while (l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }

        Node newHead = head.next;

        l1 = head;
        while (l1 != null) {
            if (l1.random != null) {
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;
        }

        l1 = head;
        while (l1 != null) {
            Node l2 = l1.next;
            l1.next = l2.next;
            if (l2.next != null) {
                l2.next = l2.next.next;
            }
            l1 = l1.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        LinkedListt ls = new LinkedListt();
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.random = node2;
        node2.random = node1;
        ls.copyRandomListOp(node1);

    }
}
