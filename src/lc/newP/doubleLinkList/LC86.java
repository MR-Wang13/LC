package lc.newP.doubleLinkList;

public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode preLeft  = new ListNode(-1,left);
        ListNode preRight  = new ListNode(-1,right);

        while (head!=null){
            if (head.val>=x){
                right.next  = head;
                right = right.next;
            }else {
                left.next = head;
                left = left.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = preRight.next.next;
        return preLeft.next.next;
    }
}
