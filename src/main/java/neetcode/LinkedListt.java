package neetcode;
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class LinkedListt {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseList(slow.next);
        ListNode first = head;
        while(first!= null && second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        first.next = second;
    }
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
