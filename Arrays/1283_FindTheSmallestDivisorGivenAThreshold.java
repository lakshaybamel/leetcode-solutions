/**1283. Find the Smallest Divisor Given a Threshold
Solved
Medium
Topics - Staff, Array, Binary Search, Weekly Contest 166

Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

Example 1:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

Example 2:
Input: nums = [44,22,33,11,1], threshold = 5
Output: 44

Constraints:
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^6
nums.length <= threshold <= 10^6 */





class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        // find max
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sumByD(nums, mid) <= threshold) {
                high = mid - 1;   // try smaller divisor
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int sumByD(int[] nums, int div) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + div - 1) / div; // ceil(num/div)
        }

        return sum;
    }
}