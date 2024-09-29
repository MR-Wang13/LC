package lc.top150.linkedlist;

public class LC61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int size =0;


        ListNode pre = new ListNode(-1,head);
        while (pre.next!=null){
            size++;
            pre = pre.next;
        }
        if(head == null || k ==0 || k%size==0){
            return head;
        }
        k = k%size;

        ListNode reversed = reverseLinkedList(head);

        ListNode h1 = reverseLinkedListN(reversed,1,k);

        ListNode h2 = reverseLinkedListN(h1,k+1,size);

        return h2;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head== null ||head.next==null){
            return head;
        }

        ListNode last = reverseLinkedList(head.next);
        head.next.next=head;
        head.next = null;
        return last;
    }
    public ListNode reverseLinkedListN(ListNode head,int m,int n) {
        post = null;
        int length = n-m+1;
        ListNode dump = new ListNode(-1,head);
        ListNode pre = null;
        while (m>1){
            pre = head;
            head = head.next;
            m--;
        }

        ListNode fisrt = reverseN(head,length);
        head.next = post;
        if (pre == null){
            return fisrt;
        }else {
            pre.next = fisrt;
            return dump.next;
        }
    }
    ListNode post = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n==1){
            post = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public ListNode rotateRight2(ListNode head, int k) {

        ListNode pre = head;
        int size = 0;
        while (pre!=null){
            size++;
            pre = pre.next;
        }
        if (head == null ||size==0|| k ==0 || k%size==0){
            return head;
        }
        k = k%size;


        ListNode dump = new ListNode(-1,head);
        ListNode target = dump;
        ListNode fast = dump;
        for (int i = 0 ; i<k; i++){
            fast = fast.next;
        }

        while (fast.next!=null){
            target = target.next;
            fast = fast.next;
        }
        ListNode newHead = target.next;
        target.next = null;
        fast.next = head;
        return newHead;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(13);
        ListNode n3 = new ListNode(11);
        ListNode n4 = new ListNode(10);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        LC61RotateList lc = new LC61RotateList();
        System.out.println(lc.rotateRight2(n1,2));
    }
}
