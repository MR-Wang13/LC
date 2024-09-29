package lc.top150.linkedlist;

import java.util.HashMap;

public class L138 {
    public Node copyRandomList(Node head) {
        HashMap<Integer,Node> oriMapPtoN = new HashMap<>();
        HashMap<Node,Integer> oriMapNtoP = new HashMap<>();

        Node temp = head;
        int count = 1;
        while (temp!=null){
            oriMapPtoN.put(count,temp);
            oriMapNtoP.put(temp,count);
            temp= temp.next;
            count++;
        }
        HashMap<Integer,Node> newMapPtoN = new HashMap<>();

        Node pre = new Node(-1);
        Node cur = pre;
        count=1;
        while (head!=null){
            Node newNode;
            if (newMapPtoN.containsKey(count)){
                newNode = newMapPtoN.get(count);
            }else {
                newNode =new Node(head.val);
                newMapPtoN.put(count,newNode);
            }

            if (head.random!=null){
                if (newMapPtoN.containsKey(oriMapNtoP.get(head.random))){
                    newNode.random = newMapPtoN.get(oriMapNtoP.get(head.random));
                }else {
                    Node newRadomNode = new Node(head.random.val);
                    newNode.random = newRadomNode;
                    newMapPtoN.put(oriMapNtoP.get(head.random),newRadomNode);
                }

            }
            count++;
            cur.next = newNode;
            cur = cur.next;
            head = head.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        L138 lc = new L138();
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next =n2;
        n2.next =n3;
        n3.next =n4;
        n4.next =n5;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        lc.copyRandomList(n1);
    }
}
