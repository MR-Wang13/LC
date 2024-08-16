package lc.top150.binarytree;

public class LC106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode node = buildByInAndPost(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return node;
    }

    private TreeNode buildByInAndPost(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart>inEnd||postStart>postEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        int index=0;
        for (int i = inStart;i<=inEnd;i++){
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildByInAndPost(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        root.right = buildByInAndPost(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);

        return root;
    }

    public static void main(String[] args) {
        LC106 lc = new LC106();
        int[]  preorder = {9,3,15,20,7};
        int[] inorder = {9,15,7,20,3};
        lc.buildTree(preorder,inorder);
    }
}
