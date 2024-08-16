package lc.top150.binarytree;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node  =  buildByPreAndIn(preorder,0,preorder.length-1,inorder,0,inorder.length-1);


        return  node;
    }

    private TreeNode buildByPreAndIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart>preEnd || inStart>inEnd){
            return null;
        }
        int rootVal = preorder[preStart];

        int index= 0;
        for (int i = inStart;i<=inEnd;i++){
            if (rootVal == inorder[i]){
                index = i;
                break;
            }
        }

        int leftSize= index - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = buildByPreAndIn(preorder,preStart+1,preEnd,inorder,inStart,index-1);

        root.right = buildByPreAndIn(preorder,preStart+1+leftSize,preEnd,inorder,index+1,inEnd);

        return root;
    }

    public static void main(String[] args) {
        LC105 lc = new LC105();
        int[]  preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        lc.buildTree(preorder,inorder);
    }

}
