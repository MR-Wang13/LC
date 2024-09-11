package ng.ziprecruiter;

public class KeyChangeCounter {

        // Method to count the number of key changes
        public static int countKeyChanges(char[] recording) {
           if (recording == null || recording.length<=1){
               return 0;
           }
           int steps = 0;
           for (int i =0 ; i<recording.length-1; i++){
               if (Character.toLowerCase(recording[i]) != Character.toLowerCase(recording[i+1])){
                   steps++;
               }
           }
           return steps;
        }

        public static void main(String[] args) {
            // Example input: ['W', 'w', 'a', 'A', 'a']
            char[] recording = {'W', 'w', 'a', 'A', 'a'};

            // Call the method to count key changes and print the result
            int result = countKeyChanges(recording);
            System.out.println("Number of key changes: " + result);
        }


}
