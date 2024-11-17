package ng.meta;

public class LC938 {
    static int sum;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        rangeSumBST(root.left, low, high);

        if(root.val >= low && root.val <=high) {
            sum += root.val;
        }

        rangeSumBST(root.right, low, high);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(10);
        TreeNode node2  = new TreeNode(5);

        TreeNode node3  = new TreeNode(15);
        TreeNode node4  = new TreeNode(3);
        TreeNode node5  = new TreeNode(7);
        TreeNode node6  = new TreeNode(7);
        TreeNode node7  = new TreeNode(18);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        //node3.left = node6;
        node3.right=node7;
        System.out.println(rangeSumBST(node1,7,15));
    }
}
