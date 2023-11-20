package lc.LinkList;

public class ReverseLinkedList {
    ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur =temp;
        }

        return pre;
    }
    /**
     * 递归解法
     *
     * **/
    ListNode reverseListUsingRecursion(ListNode head){
        return reverse(null, head);
    }
    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        ListNode returnNode = reverse(cur, temp);
        return returnNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new  ListNode(5);
        ListNode node2 = new  ListNode(4,node1);
        ListNode node3 = new  ListNode(3,node2);
        ListNode node4 = new  ListNode(2,node3);
        ListNode head = new  ListNode(1,node4);
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode returnNode=  list.reverseListUsingRecursion(head);
        System.out.println(returnNode);
    }

}
