package ng.meta;

public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }else if(left!=null ){
            return left;
        }else if(right!=null){
            return right;
        }
        return null;
    }
}
