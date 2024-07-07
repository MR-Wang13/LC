package lc.top150.binarytree;

public class LC104 {
    int max = 0;
    public int maxDepth(TreeNode root) {
        max = 0;
        dfs(root,0);
        return max;
    }

    private void dfs(TreeNode root, int level) {
        if (root==null){
            max = Math.max(max,level);
            return;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
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
        node3.left=node5;

        LC104 lc = new LC104();
        System.out.println(lc.maxDepth(node1));

    }
}
