package lc.top150.divideConq;

import lc.top150.linkedlist.ListNode;

import java.util.List;

public class LC148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode leftHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(leftHead);
        return mergeSorted(left,right);
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow =head;
        ListNode fast =head.next;
        while (fast != null&&fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeSorted(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left!=null && right!=null){
            if(left.val<= right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left ==null?right:left;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        LC148 lc = new LC148();
        System.out.println(lc.sortList(n1));
    }
}
