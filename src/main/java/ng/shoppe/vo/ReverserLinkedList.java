package ng.shoppe.vo;


import lc.newP.doubleLinkList.ListNode;

public class ReverserLinkedList {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur!= null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverseListRecurse(ListNode head) {
      if(head.next == null){
          return head;
      }
      ListNode newHead = reverseListRecurse(head.next);
      head.next.next = head;
      head.next = null;
      return newHead;
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = new ListNode(600,head);
        ListNode pre = dump;
        int n = right-left +1;
        while (left-->1){
            pre = pre.next;
        }
        ListNode newHead = reverseListK(pre.next,n);
        if(pre.val == 600){
            return newHead;
        }else {
            pre.next = newHead;
        }
        return dump.next;
    }
    static ListNode post;
    private static ListNode reverseListK(ListNode head,int k) {
        if(k == 1){
            post = head.next;
            return head;
        }
        ListNode newHead = reverseListK(head.next,k-1);
        head.next.next = head;
        head.next = post;
        return newHead;
    }
    static ListNode start;
    static ListNode end;

    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur!=null&&length++>=0){
            cur = cur.next;
        }
        int timesOfReversion = length/k;
        start = head;
        boolean getHead = true;
        ListNode preEnd = null;
        while (start!=null && timesOfReversion-->0){
            ListNode nh= reverseListKForGroup(start,k);
            if(getHead){
                newHead = nh;
                getHead = false;
            }
            if(preEnd != null){
                preEnd.next = nh;
            }
            preEnd = end;
        }
        if(preEnd!=null){
            preEnd.next = start;
        }
        return  getHead?head:newHead;
    }
    private static ListNode reverseListKForGroup(ListNode head,int k) {
        if(k == 1){
            start = head.next;
            return head;
        }
        ListNode newHead = reverseListKForGroup(head.next,k-1);
        head.next.next = head;
        head.next = start;
        end = head;
        return newHead;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(2,node3);
        ListNode head =  new ListNode(1,node4);
        //reverseList(head);
        //ListNode result = reverseListRecurse(head);
        //System.out.println(result.val);
        //reverseBetween(head,3,5);
        reverseKGroup(head,2);
    }
}
