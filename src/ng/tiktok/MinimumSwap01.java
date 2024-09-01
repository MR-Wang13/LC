package ng.tiktok;

public class MinimumSwap01 {
    public int min(int[] arr){
        int left = 0,right = arr.length-1;
        int swapCount1=0;
        //0 在左 1 在右
        while (left<right){
            if (arr[left] == 1 ){
                if (arr[right]==0){
                    swapCount1++;
                    left++;
                }
                right--;

            }else {
                if (arr[right]==1){
                    right--;
                }
                left++;
            }

        }

        left = 0;
        right = arr.length-1;
        int swapCount2=0;
        //1 左 0 右
        while (left<right){
            if (arr[left] == 0 ){
                if (arr[right]==1){
                    swapCount2++;
                    left++;
                }
                right--;
            }else {
                if (arr[right]==0){
                    right--;
                }
                left++;
            }

        }

        return Math.min(swapCount2,swapCount1);
    }
    public static int minimizeTransitions(int[] tiktokStorage) {
        int n = tiktokStorage.length;
        int leftPointer = 0, rightPointer = n - 1;
        int swapCount = 0;

        while (leftPointer < rightPointer) {
            // 找到左边的第一个1
            while (leftPointer < n && tiktokStorage[leftPointer] == 0) {
                leftPointer++;
            }

            // 找到右边的第一个0
            while (rightPointer >= 0 && tiktokStorage[rightPointer] == 1) {
                rightPointer--;
            }

            // 如果leftPointer还在rightPointer左边，交换它们
            if (leftPointer < rightPointer) {
                swapCount++;
                leftPointer++;
                rightPointer--;
            }
        }

        return swapCount;
    }
    int getSwapCounts(int[] arr,int frontNum,int endNum){
        int left =0,right = arr.length-1;
        int swapCount = 0;
        while (left<right){
            while (left<arr.length && arr[left]==frontNum){
                left++;
            }
            while (right>=0 && arr[right]==endNum){
                right--;
            }

            if (left<right){
                left++;
                right--;
                swapCount++;
            }
        }

        return swapCount;

    }
    int getSwapMin(int[] arr){
        return Math.min(getSwapCounts(arr,0,1),getSwapCounts(arr,1,0));
    }
    public static void main(String[] args) {
        MinimumSwap01 swap01 = new MinimumSwap01();
        int[] arr = {0,1,1,0,1,0};
        System.out.println(swap01.getSwapMin(arr));
    }
}
