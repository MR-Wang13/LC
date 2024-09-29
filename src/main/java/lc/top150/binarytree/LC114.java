package lc.top150.binarytree;

public class LC114 {
    public void flatten(TreeNode root) {
        root  = transInPreOrder(root);
        System.out.println(root);
    }

    private TreeNode transInPreOrder(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = transInPreOrder(root.left);
        TreeNode right = transInPreOrder(root.right);

        root.left = null;
        if (left!=null) {
            root.right = left;
            TreeNode temp = left;
            while (temp.right!=null){
                temp = temp.right;
            }
            temp.right = right;
        }

        return root;
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

        LC114 lc = new LC114();
        lc.flatten(node1);
    }

}
