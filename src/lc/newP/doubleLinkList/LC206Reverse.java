package lc.newP.doubleLinkList;

public class LC206Reverse {
    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null){
           return head;
       }
       ListNode last = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return last;
    }
}
