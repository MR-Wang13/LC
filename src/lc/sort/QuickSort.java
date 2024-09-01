package lc.sort;

public class QuickSort {

    // 主方法，用于调用快速排序
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort qs = new QuickSort();
       qs.partition(arr,0,5);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // 快速排序函数
    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi 是分区索引，arr[pi] 已经排好序
            int pi = partition(arr, low, high);

            // 递归排序
            quickSort(arr, low, pi - 1);  // 排序左边部分
            quickSort(arr, pi + 1, high); // 排序右边部分
        }
    }

    // 分区函数
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 选择最后一个元素作为基准
        int i = (low - 1);  // 较小元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (arr[j] <= pivot) {
                i++;

                // 交换 arr[i] 和 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换 arr[i+1] 和 arr[high] (或基准)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // 打印数组
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

