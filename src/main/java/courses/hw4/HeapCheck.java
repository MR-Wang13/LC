package courses.hw4;

public class HeapCheck {
    public static boolean isHeap(int[] arr, boolean isMaxHeap) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (isMaxHeap) {
                if ((left < n && arr[i] < arr[left]) || (right < n && arr[i] < arr[right])) {
                    return false;
                }
            } else {
                if ((left < n && arr[i] > arr[left]) || (right < n && arr[i] > arr[right])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4}; // Example array
        System.out.println("Is Max Heap: " + isHeap(arr, true));
        System.out.println("Is Min Heap: " + isHeap(arr, false));
    }
}
