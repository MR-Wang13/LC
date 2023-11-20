package lc.LinkList;

public class RemoveFromEnd {

    public ListNode removeNthFromEnd(ListNode head,int n){

        ListNode preHead = new ListNode(-1,head);

        ListNode fastIndex = preHead;
        ListNode slowIndex = preHead;

        for (int i = 0; i<n; i++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next!=null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        slowIndex.next = slowIndex.next.next;

        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new  ListNode(4);
        ListNode node2 = new  ListNode(3,node1);
        ListNode node3 = new  ListNode(2,node2);
        ListNode node4 = new  ListNode(1,node3);
        ListNode head = new  ListNode(0,node4);

        RemoveFromEnd ele = new RemoveFromEnd();
        ele.removeNthFromEnd(head,2);
    }
}
