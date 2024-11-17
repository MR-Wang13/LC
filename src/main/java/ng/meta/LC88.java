package ng.meta;

public class LC88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while(index >= 0){
            if(j < 0) {
                nums1[index--] = nums1[i--];
                continue;
            }
            if(i < 0) {
                nums1[index--] = nums2[j--];
                continue;
            }
            if( nums1[i] > nums2[j]){
                nums1[index--] = nums1[i--];
            }else{
                nums1[index--] = nums2[j--];
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
    }
}
