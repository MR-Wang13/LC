package ng.shoppe.vo;

import java.util.HashSet;

public class LC82 {
    static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

        public static ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next==null){
                return head;
            }
            ListNode dump = new ListNode(-1);
            ListNode index = dump;
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = null;
            while (cur != null){
                next = cur.next;

                if(pre==null){
                    if(cur.val != next.val){
                        index.next = cur;
                        index = index.next;
                    }
                }else if (next == null){
                    if(cur.val != pre.val){
                        index.next = cur;
                        index = index.next;
                    }
                }else {
                    if(cur.val != pre.val && cur.val != next.val){
                        index.next = cur;
                        index = index.next;
                    }
                }
                pre = cur;
                cur = cur.next;
            }
            index.next = cur;
            return dump.next;
        }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2,node3);
        ListNode head =  new ListNode(1,node4);
        deleteDuplicates(head);
    }
}
