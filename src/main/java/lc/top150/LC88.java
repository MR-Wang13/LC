package lc.top150;

public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int index =m+n-1;
        while(index>=0){
            if(j>=0&&(i<0||nums1[i]<=nums2[j])){
                nums1[index--]=nums2[j--];
            }else {
                nums1[index--]=nums1[i--];
            }
        }
        System.out.println(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {2};
        int n = 1;
        LC88 lc = new LC88();
        lc.merge(nums1,m,nums2,n);
    }
}
