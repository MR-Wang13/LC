package lc.doublePoint;

import lc.LinkList.ListNode;


public class RemoveFromEnd {
    static ListNode removeFEnd(ListNode head , int n){
        if (head == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while (n>0){
            fast=fast.next;
            n--;
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new  ListNode(5);
        ListNode node2 = new  ListNode(4,node1);
        ListNode node3 = new  ListNode(3,node2);
        ListNode node4 = new  ListNode(2,node3);
        ListNode head = new  ListNode(1,node4);
        removeFEnd(head,2);
    }
}
