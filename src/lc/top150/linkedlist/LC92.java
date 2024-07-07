package lc.top150.linkedlist;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(-1,head);
        ListNode pre = null;
        int length  = n-m+1;
        while (m>1){
            pre = head;
            head = head.next;
            m--;
        }

        ListNode first = reverseN(head,length);
        head.next = post;
        if (pre == null){
            return first;
        }else {
            pre.next =  first;
            return dump.next;
        }
    }

    ListNode post = null;
    private ListNode reverseN(ListNode node, int length) {
        if (length==1){
            post = node.next;
            return node;
        }
        ListNode last =  reverseN(node.next,length-1);
        node.next.next =node;

        return last;
    }
}
