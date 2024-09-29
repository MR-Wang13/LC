package lc.newP.doubleLinkList;

public class LC92 {
    public ListNode reverseBetween1(ListNode head, int m, int n) {

        if (m == 1){
            return reverseN(head,n);
        }

        head.next = reverseBetween(head.next,m-1,n-1);

        return head;


    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(-1,head);
        ListNode pre = null;
        int length = n -m+1;
        while (m>1){
                pre = head;
                head = head.next;
                m--;
        }

        // 前进到反转的起点触发 base case
        ListNode node = reverseN(head, length);
        if(pre == null) {

          return node;
        }else {
            pre.next = node;
            return dump.next;
        }





    }

    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    ListNode reverseN1(ListNode head, int n) {
        if (n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN1(head,n-1);
        head.next.next = head;

        head.next = successor;
        return last;
    }
    public static void main(String[] args) {
        LC92 lc92 = new LC92();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node4);
        lc92.reverseBetween(head,2,4);

    }
}
