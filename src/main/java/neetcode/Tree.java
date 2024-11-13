package neetcode;

public class Tree {
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    static TreeNode max = null;

    static public boolean isValidBST(TreeNode root) {
        max = null;
        if(root.left == null && root.right == null){
            return true;
        }
        return checkTree2(root);
    }

    static public boolean checkTree2(TreeNode root) {
        if (root == null){
            return true;
        }
        boolean left =checkTree2(root.left);
        if(max!=null && max.val >= root.val) {
            return false;
        }
        max = root;
        boolean right =checkTree2(root.right);
        return  left && right;
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
        System.out.println(isValidBST(node1));
    }
}
