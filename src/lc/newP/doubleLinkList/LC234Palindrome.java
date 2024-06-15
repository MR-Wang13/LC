package lc.newP.doubleLinkList;

public class LC234Palindrome {
    ListNode left ;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode head) {
        if (head == null){
            return true;
        }
        boolean res = traverse(head.next);
        res = res && (left.val == head.val);
        left = left.next;
        return res;
    }

    public static void main(String[] args) {
        LC234Palindrome lc92 = new LC234Palindrome();
        //ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2,node2);
        ListNode node4 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node4);
        System.out.println(lc92.isPalindrome(head));
    }
}
