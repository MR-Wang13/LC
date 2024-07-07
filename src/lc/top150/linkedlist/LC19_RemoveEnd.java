package lc.top150.linkedlist;

public class LC19_RemoveEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1,head);
        ListNode fast = pre;
        ListNode slow = pre;

        for (int i =0 ; i<n ;i++){
            fast = fast.next;
        }

        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(13);
        ListNode n3 = new ListNode(11);
        ListNode n4 = new ListNode(10);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        LC19_RemoveEnd lc  = new LC19_RemoveEnd();
        System.out.println(lc.removeNthFromEnd(n1,3));
    }
}
