package lc.top150.binarytree;

public class LC222 {
    int count = 0;
    public int countNodes(TreeNode root) {
        count=0;
        countNode(root);
        return count;
    }

    private void countNode(TreeNode root) {
        if (root == null){
            return;
        }
        count++;
        countNode(root.left);
        countNode(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left=node2;
        node1.right=node5;
        node2.left=node3;
        node2.right=node4;
        node5.right=node6;

        LC222 lc = new LC222();
        System.out.println(lc.countNodes(node1));
    }
}
