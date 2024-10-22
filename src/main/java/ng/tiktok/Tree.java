package ng.tiktok;

class TreeNode {
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

public class Tree {
    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        return sumOfBoth(root);


    }

    public static int sumOfBoth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLength = sumOfBoth(root.left) ;
        int rightLength = sumOfBoth(root.right);
        max = Math.max(max,leftLength+rightLength);
        return Math.max(leftLength,rightLength)+1;
    }
    public static int goodNodes(TreeNode root) {
        return dfs(root,-101);
    }
    public  static int dfs(TreeNode root, int max) {

        if(root == null){
            return 0;
        }

        int cur = 0;
        if(root.val>max){
            cur =1;
        }
        max = Math.max(max,root.val);

        int left = dfs(root.left,max);
        int right = dfs(root.right,max);

        return right+left+cur;
    }
    public static void main(String[] args) {

        TreeNode node1  = new TreeNode(3);
        TreeNode node2  = new TreeNode(3);

        TreeNode node3  = new TreeNode(4);
        TreeNode node4  = new TreeNode(2);
        TreeNode node5  = new TreeNode(1);
        TreeNode node6  = new TreeNode(5);
        TreeNode node7  = new TreeNode(7);
        TreeNode node8  = new TreeNode(8);
        TreeNode node9  = new TreeNode(9);
        node1.left = node2;

        node2.left = node3;
        node2.right = node4;
        //System.out.println(diameterOfBinaryTree(node1));
        System.out.println(goodNodes(node1));
    }
}
