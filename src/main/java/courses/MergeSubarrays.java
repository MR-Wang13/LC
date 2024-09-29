package courses;

public class MergeSubarrays {

        // Function to merge two sorted subarrays of array A.
        // The first subarray is A[0...m-1] and the second subarray is A[m...m+n-1].
        public static void merge(int[] A, int m, int n) {
            int minSize = Math.min(m, n);
            int[] Aux = new int[minSize];
            int i, j, k, l;

            // If the first subarray is smaller or equal, we'll store it in the auxiliary array
            if (minSize == m) {
                for (i = 0; i < m; i++) {
                    Aux[i] = A[i];
                }
                i = 0;
            } else { // Otherwise, we store the second subarray
                for (j = m; j < m + n; j++) {
                    Aux[j - m] = A[j];
                }
                i = m; // We start comparing from the beginning of the first subarray
            }

            j = m; // Start of the second subarray
            k = 0; // Start of the merged array
            l = 0; // Index for Aux array

            // Merge back to A until one of the subarrays is exhausted
            while (i < m && j < m + n && l < minSize) {
                if (Aux[l] <= A[j]) {
                    A[k++] = Aux[l++];
                } else {
                    A[k++] = A[j++];
                }
            }

            // If there are remaining elements in Aux, add them back to A
            while (l < minSize) {
                A[k++] = Aux[l++];
            }

            // If there are remaining elements in the second subarray, they are already in place
            // so no action is required for them.
        }

        // Main method for testing the merge function
        public static void main(String[] args) {
            // Example usage:
            // The first subarray is A[0...m-1] and the second subarray is A[m...m+n-1].
            int[] A = {1, 3, 5, 7, 2, 4, 6, 8}; // Assuming this is the given sorted subarrays.
            int m = 4; // Length of the first sorted subarray
            int n = 4; // Length of the second sorted subarray

            merge(A, m, n);

            // Printing the merged array
            for (int num : A) {
                System.out.print(num + " ");
            }
        }



}

