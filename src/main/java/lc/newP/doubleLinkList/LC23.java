package lc.newP.doubleLinkList;

import java.util.PriorityQueue;

public class LC23 {

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        PriorityQueue<ListNode> que = new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node : lists){
            que.add(node);
        }
        while (!que.isEmpty()){
            ListNode next = que.poll();
            p.next = next;
            if (next.next!=null){
                que.add(next.next);
            }
            p = p.next;
        }
        return  pre.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0){
            return null;
        }
        ListNode head = lists[0];
        for (int i = 0 ; i<lists.length-1;i++){
            head = mergeTwoLists(lists[i+1],lists[i]);
        }
        return head;
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {

            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

}
