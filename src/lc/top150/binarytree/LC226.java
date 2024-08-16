package lc.top150.binarytree;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = left;
        root.left = right;
        root.right = temp;
        invert(left);
        invert(right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        LC226 lc = new LC226();
        lc.invertTree(node1);

    }
}
