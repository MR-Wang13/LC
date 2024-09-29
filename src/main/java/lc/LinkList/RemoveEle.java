package lc.LinkList;

public class RemoveEle {
    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur!=null){
            if (cur.val==val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    /**
     * 不添加虚拟节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 不添加虚拟节点and pre Node方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     *
     * while(head ! = null & & head.val = = val){
     *             head = head.next;
     *         }
     *         ListNode curr = head;
     *         while(curr!=null){
     *             while(curr.next!=null && curr.next.val == val){
     *                 curr.next = curr.next.next;
     *             }
     *             curr = curr.next;
     *         }
     *         return head;
     */
    public ListNode removeElements2(ListNode head, int val) {
        while(head!=null && head.val == val){
            head = head.next;
        }
        ListNode cur = head;
        while (cur!=null){
            if (cur.next!=null && cur.next.val==val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return head;
    }
    public static void main(String[] args) {
        ListNode node1 = new  ListNode(4);
        ListNode node2 = new  ListNode(4,node1);
        ListNode node3 = new  ListNode(4,node2);
        ListNode node4 = new  ListNode(4,node3);
        ListNode head = new  ListNode(4,node4);

        RemoveEle ele = new RemoveEle();
        ele.removeElements2(head,4);
    }
}
