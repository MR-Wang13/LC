package lc.newP.doubleLinkList;

public class LC25ReverseK {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode a , b;
        a  = b =head;
        for (int i = 0 ; i<k ; i++){
            if (b==null)
                return head;
            b = b.next;
        }

        ListNode newHead = reverseBetween(a,b);//这里回有b为空的情况 应为是反转[a,b)区间
        a.next = reverseKGroup(b,k);

        return newHead;
    }
    ListNode reverseBetween(ListNode a, ListNode b){
        if(a.next == null){
            return a;
        }
        ListNode pre ,cur,post = a.next;
        pre=null ; cur=a;
        while (cur!=b){

           /* post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;*/

            cur.next = pre;
            pre = cur;
            cur = post;
            if (cur == null){
                break;
            }
            post = cur.next;
        }

        return pre;
    }
    public static void main(String[] args) {
        LC25ReverseK lc92 = new LC25ReverseK();
        //ListNode node1 = new ListNode(5);
        //ListNode node2 = new ListNode(4,node1);
        //ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(2);
        ListNode head = new ListNode(1,node4);
        lc92.reverseKGroup(head,2);

    }
}
