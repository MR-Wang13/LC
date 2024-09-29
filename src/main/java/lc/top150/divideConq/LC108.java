package lc.top150.divideConq;

import lc.top150.binarytree.TreeNode;

public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = helper(0,nums.length-1,nums);
        return node;
    }

    private TreeNode helper(int l, int r, int[] nums) {
        if (l<0 || r>=nums.length||l>r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(l,mid-1,nums);
        node.right = helper(mid+1,r,nums);

        return node;
    }

    public static void main(String[] args) {
        LC108 lc = new LC108();
        int[] nums  = {-10,-3,0,5,9};
        System.out.println(lc.sortedArrayToBST(nums));
    }
}
