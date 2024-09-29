package lc.top150.binarytree.bst;

import lc.top150.binarytree.LC104;
import lc.top150.binarytree.TreeNode;

public class LC530 {
    int min = Integer.MAX_VALUE;
    int pre = 0;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        BtsFor(root);
        return min;
    }

    private void BtsFor(TreeNode root) {

        if (root == null){
            return;
        }
        BtsFor(root.left);
        if (pre != 0 ) {
            min = Math.min(min, Math.abs(root.val - pre));
        }
        pre = root.val;
        BtsFor(root.right);
    }

    public static void main(String[] args) {
        LC530 lc = new LC530();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        node1.right=node3;
        node3.left=node4;

        System.out.println(lc.getMinimumDifference(node1));
    }
}
