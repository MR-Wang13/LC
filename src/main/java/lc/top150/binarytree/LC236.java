package lc.top150.binarytree;

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left!=null&&right!=null){
            return root;
        }else if(left!=null&&right==null){
            return left;
        }else if (left!=null&&right==null){
            return right;
        }

        return null;
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

        LC236 lc = new LC236();
        System.out.println(lc.lowestCommonAncestor(node1,node2,node4));

    }
}
