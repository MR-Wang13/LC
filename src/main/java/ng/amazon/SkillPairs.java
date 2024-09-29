package ng.amazon;

import java.util.Arrays;

public class SkillPairs {
    public static int countSkillPairs(int[] skill, int minSkill, int maxSkill) {
        int n = skill.length;
        int count = 0;

        // Step 1: Sort the skill array
        Arrays.sort(skill);

        // Step 2: For each skill[i], find the valid range using binary search
        for (int i = 0; i < n; i++) {
            int minJ = findLowerBound(skill, i + 1, n - 1, minSkill - skill[i]);
            int maxJ = findUpperBound(skill, i + 1, n - 1, maxSkill - skill[i]);

            // If we found a valid range, count the number of valid pairs
            if (minJ != -1 && maxJ != -1 && minJ <= maxJ) {
                count += (maxJ - minJ + 1);
            }
        }

        return count;
    }

    // Function to find the first index where skill[j] + skill[i] >= minSkill using binary search
    private static int findLowerBound(int[] skill, int start, int end, int target) {
        int left = start, right = end, res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (skill[mid] >= target) {
                res = mid;  // Potential lower bound found
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;  // Return the first valid j or -1 if no valid j exists
    }

    // Function to find the last index where skill[j] + skill[i] <= maxSkill using binary search
    private static int findUpperBound(int[] skill, int start, int end, int target) {
        int left = start, right = end, res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (skill[mid] <= target) {
                res = mid;  // Potential upper bound found
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;  // Return the last valid j or -1 if no valid j exists
    }

    public static void main(String[] args) {
        int[] skills ={2,3,4,5,6};
        int min = 5;
        int max = 7;

        System.out.println(countSkillPairs(skills,min,max));
    }
}
