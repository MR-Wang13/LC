import java.util.Arrays;

public class SortAndSearchTest {

    /**
     * 合并两个有序数组
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

     * 示例 1：
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     * 示例 2：
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * 解释：需要合并 [1] 和 [] 。
     * 合并结果是 [1] 。
     * 示例 3：
     *
     * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
     * 输出：[1]
     * 解释：需要合并的数组是 [] 和 [1] 。
     * 合并结果是 [1] 。
     * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
     *  
     *
     * 提示：
     *
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     *  
     *
     * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
     *
     * **/

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0){
            return;
        }
        if (m==0){
            System.arraycopy(nums2,0,nums1,0,nums2.length);
            return;
        }
        int i = 0;
        int j = 0;
        int index=0;
        int[] temp = new int[m+n];
        while (i<m && j<n){
            if (nums1[i]<=nums2[j]){
                temp[index++]=nums1[i++];
            }else {
                temp[index++]=nums2[j++];
            }
        }
        int[] left ;
        if (i!=m){
            left= Arrays.copyOfRange(nums1,i,m);
        }else if (j!=n){
            left= Arrays.copyOfRange(nums2,j,n);
        }else {
            return;
        }
        System.arraycopy(temp,0,nums1,0,temp.length);

        System.arraycopy(left,0,nums1,m+n-left.length,left.length);

}

/***
 * 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例 1：
 *
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 示例 2：
 *
 * 输入：n = 1, bad = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= bad <= n <= 231 - 1
 * 相关标签
 *
 *
 * */
    public static int firstBadVersion(int n) {
       return 0;
    }
    /**
     *
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶

     * */
    public static int climbStairs(int n) {

       return 0;
    }

    public static void main(String[] args) {

    }
}
