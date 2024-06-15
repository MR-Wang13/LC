package lc.newP.doubleLinkList;

public class LC19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(-1,head);
        ListNode ahead = pre;

        ListNode behind = pre;

        int i;
        for (i = 0 ; i<n;i++){
            ahead = ahead.next;
        }

        while (ahead!=null&&ahead.next!=null){
            behind=behind.next;
            ahead = ahead.next;
        }

        behind.next = behind.next.next;

        return pre.next;



    }
}
