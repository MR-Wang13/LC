package lc.top150.binarytree.bst;

import lc.top150.binarytree.LC104;
import lc.top150.binarytree.TreeNode;

public class LC230 {
    int result = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        result = 0;
        btsFor(root);
        return result;
    }

    private void btsFor(TreeNode root) {
        if (root == null){
            return;
        }
        btsFor(root.left);
        count-- ;
        if (count == 0){
            result = root.val;
            return;
        }
        btsFor(root.right);

    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;

        LC230 lc = new LC230();
        System.out.println(lc.kthSmallest(node1,1));
    }
}
