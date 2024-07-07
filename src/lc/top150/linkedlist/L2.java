package lc.top150.linkedlist;

public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode cur = pre;
        int bit = 0;
        while (l1!=null && l2!=null){
            int sum = l1.val + l2.val + bit;
            ListNode newNode = new ListNode();
            if (sum>=10){
                newNode.val = sum-10;
                bit=1;
            }else {
                bit = 0;
                newNode.val = sum;
            }
            cur.next = newNode;
            cur = cur.next;
            l1 = l2.next;
            l2 = l2.next;
        }
        ListNode left  = l1==null?l2:l1;
        if (bit==0){
            cur.next = left;
        }else {
            while (left!=null){
                int sum = left.val +bit;
                ListNode newNode = new ListNode();
                if (sum>10){
                    newNode.val = sum-10;
                    bit=1;
                }else {
                    bit = 0;
                    newNode.val = sum;
                }
                cur.next = newNode;
                cur = cur.next;
                left = left.next;
            }
        }
        if (bit == 1 ){
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
        }
        return pre.next;
    }
}
