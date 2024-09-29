package lc.LinkList;

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode a , ListNode b){
        int lengthA = 0 , lengthB=0;

        ListNode ahead = a, bHead = b;

        while (ahead!=null){
            ahead= ahead.next;
            lengthA++;
        }

        while (bHead!=null){
            bHead = bHead.next;
            lengthB++;
        }

        ahead = a;
        bHead = b;
        int diff ;
        if (lengthA>lengthB){
            diff = lengthA - lengthB;
            while (diff>0){
                ahead=ahead.next;
                diff--;
            }
        }else {
            diff = lengthB - lengthA;
            while (diff>0){
                bHead=bHead.next;
                diff--;
            }
        }

        while (ahead!=null){
            if (ahead == bHead){
                return ahead;
            }
            ahead = ahead.next;
            bHead = bHead.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new  ListNode(5);
        ListNode node2 = new  ListNode(4,node1);
        ListNode node3 = new  ListNode(3,node2);
        ListNode node4 = new  ListNode(2,node3);
        ListNode head = new  ListNode(1,node4);

        ListNode node5 = new  ListNode(6,node4);
        ListNode node6 = new  ListNode(7,node5);
        ListNode head1 = new  ListNode(8,node6);
        IntersectionNode list = new IntersectionNode();
        ListNode returnNode=  list.getIntersectionNode(head,head1);
    }
}
