package ng.meta;


public class LC426 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode pre;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode treeToDoublyList(TreeNode root) {
        inOrder(root);
        pre.next = head;
        head.pre = pre;
        return head;
    }
    private static ListNode pre = null;
    private static ListNode head = null ;
    private  static void  inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        //todo
        ListNode node = new ListNode(root.val);

        if(head !=null){
            pre.next = node;
            node.pre = pre;
            pre = node;
        }else{
            head = node;
            pre = head;

        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(5);
        TreeNode node2  = new TreeNode(2);

        TreeNode node3  = new TreeNode(9);
        TreeNode node4  = new TreeNode(1);
        TreeNode node5  = new TreeNode(3);
        TreeNode node6  = new TreeNode(4);
        TreeNode node7  = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right=node7;
        ListNode ln  = treeToDoublyList(node1);
        System.out.println(ln);
    }
}
