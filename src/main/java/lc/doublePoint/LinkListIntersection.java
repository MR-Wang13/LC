package lc.doublePoint;

import lc.LinkList.ListNode;

public class LinkListIntersection {
    static ListNode findIntersectionNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        if(head == null){
            return null;
        }
        while (slow.next!= null && fast.next!=null&& fast.next.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                meet= slow;
                break;
            }
        }
        if (meet==null){
            return  null;
        }
        while (true){
            if (meet == head){
                break;
            }
            meet = meet.next;
            head = head.next;

        }
        return  meet;
    }

    public static void main(String[] args) {
        ListNode node1 = new  ListNode(5);
        ListNode node2 = new  ListNode(4,node1);
        ListNode node3 = new  ListNode(3,node2);
        ListNode node4 = new  ListNode(2,node3);
        ListNode head = new  ListNode(1,node4);
        node4.next = head;
        findIntersectionNode(head);
    }
}
