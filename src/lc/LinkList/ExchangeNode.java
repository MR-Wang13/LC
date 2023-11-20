package lc.LinkList;

public class ExchangeNode {
    public ListNode exchange(ListNode head){
        if(head == null){
            return head;
        }
        ListNode returnHead =head.next==null?head:head.next;
        ListNode pre = new ListNode(-1,head);
        ListNode cur = head;
        ListNode next = head.next;

        while(cur!=null && next!=null){
            cur.next = next.next;
            next.next=cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
            if (cur == null){
                break;
            }
            next = cur.next;
        }
        return returnHead;
    }
    /**
     * 迭代版本
     *
     *
     * */

    public ListNode exchangeRecursion(ListNode head){
        if (head == null || head.next==null){
            return head;
        }
        ListNode next = head.next;

        ListNode newNext = exchangeRecursion(next.next);

        next.next = head;
        head.next = newNext;
        return next;

    }

    public static void main(String[] args) {
        ListNode node1 = new  ListNode(4);
        ListNode node2 = new  ListNode(3,node1);
        ListNode node3 = new  ListNode(2,node2);
        ListNode node4 = new  ListNode(1,node3);
        ListNode head = new  ListNode(0);

        ExchangeNode ele = new ExchangeNode();
        ListNode result =  ele.exchangeRecursion(node4);
        System.out.println(result);


    }
}
