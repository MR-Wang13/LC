package courses;

import java.util.Arrays;

public class Homework1 {
    /**
     *
     * There are two algorithms called Alg1 and Alg2 for a problem of size n. Alg1
     * runs in n
     * 2 microseconds and Alg2 runs in 100n log n microseconds. Alg1 can
     * be implemented using 4 hours of programmer time and needs 2 minutes of
     * CPU time. On the other hand, Alg2 requires 15 hours of programmer time
     * and 6 minutes of CPU time. If programmers are paid 20 dollars per hour and
     * CPU time costs 50 dollars per minute, how many times must a problem
     * instance of size 500 be solved using Alg2 in order to justify its development
     * cost?
     * */
    public int Exercises14InChapter1(){
        double times = 0;
        // cost for implementing Alg2  600  0.20833
        double costForAlg2 =  15*20 + 6*50 + times*0.25*50/60;
        //time for cpu using 600 (microseconds) 0.11245
        double costForAlg1 =  4*20 + 2*50 + times*0.13494*50/60;
        // times about costForAlg1 = costForAlg2
        times = 420/0.09588;
        return (int)Math.ceil(times);
    }
    /**
     * Give an algorithm for the following problem and determine its time
     * complexity. Given a list of n distinct positive integers, partition the list into
     * two sublists, each of size n/2, such that the difference between the sums of
     * the integers in the two sublists is maximized. You may assume that n is a
     * multiple of 2.
     * */
    public int Exercises33InChapter1(int[] nums){
        // Sort the array in non-decreasing order
        Arrays.sort(nums);

        // Initialize sums and maxDifference
        int sum1 = 0;
        int sum2 = 0;
        int maxDifference = 0;

        // Iterate through the sorted array
        for (int i = 0; i < nums.length; i++) {
            if (i<nums.length/2) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }

            // Calculate the difference and update maxDifference
            maxDifference = Math.max(maxDifference, Math.abs(sum1 - sum2));
        }

        return maxDifference;
    }
    /**
     *
     *
     Show that the worst-case time complexity for Binary Search (Algorithm 2.1)
     is given by
     W(n) = lg⌊n⌋+1
     when n is not restricted to being a power of 2. Hint: First show that the
     recurrence equation for W(n) is given by
     W(n)=W(⌊n/2⌋)+1
     W(1)=1
     To do this, consider even and odd values of n separately. Then use induction
     to solve the recurrence equation.
     * */
    public void Exercises4InChapter2(){
        /**When n is even values
         * W(n) = 1+W(n/2)
         * = 1+1+W(n/4)
         * = .....
         * = k+W(n/2^k)
         *
         * when n/2^k =1 -> n=2^k -> k=log₂(n)
         *
         * = log₂(n) + 1
         *
         *When n is odd values
         *          * W(n) = 1+W((n-1)/2)
         *          * = 1+1+W((n-1)/4)
         *          * = .....
         *          * = k+W((n-1)/2^k)
         *          *
         *          * when (n-1)/2^k =1 -> n-1=2^k -> k=log₂(n-1)
         *          *
         *          * = log₂(n-1) + 1
         *
         */

    }
    /**
     *
     * Suppose that, in a divide-and-conquer algorithm, we always divide an
     * instance of size n of a problem into 10 subinstances of size n/3, and the
     * dividing and combining steps take a time in Θ(n^2)Write a recurrence
     * equation for the running time T(n), and solve the equation for T(n).
     *
     * */
    public void Exercises16InChapter2(){
        /** as question described
         * T(n) = 10 * T(n/3) + Θ(n^2)
         *
         *
         * T(n) = 10 * T(n/3) + Θ(n^2)
         *      =  10 * (10* T(n/9) + Θ((1/3)^2 * n^2)) + Θ(n^2)
         *      =....
         *      = 10^k * T(n/3^k) + Θ(n^2) * [1+(1/3)^2....+(1/3^k)^2]
         *
         *      when n/3^k = 1 -> k =log3(n)
         *      = 10^(log3(n)) * T(1) + Θ(n^2) * (9/8)
         *      = n^(log3(10)) * T(1) + Θ(n^2) * (9/8)
         *      T(1) is a constant ,assumed to be c
         *      = n^(log3(10)) * c + Θ(n^2) * (9/8)
         *
         *
         *      T(n) = Θ(n^(log3(10))) + Θ(n^2)
         */

    }
    public static void main(String[] args) {
        Homework1 homework1 = new Homework1();
        //System.out.println("Exercises14, Answer: "+homework1.Exercises14InChapter1());

        int[] nums = {1, 2, 1, 2, 1, 2};
        //System.out.println("Exercises33 Answer: " + homework1.Exercises33InChapter1(nums));

        System.out.println(Math.log10(2));
    }
}
