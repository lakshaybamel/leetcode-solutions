/**239. Sliding Window Maximum
Solved
Hard
Topics - Array, Queue, Sliding Window, Heap (Priority Queue), Monotonic Queue

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
 
Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]


Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length */



class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int result[] = new int[nums.length - k + 1];

        for(int i = 0; i < k; i++) {
            pq.add(new Pair(nums[i], i));
        }
        result[0] = pq.peek().value;

        for(int i = k; i < nums.length; i++) {

            while (!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.remove();
            }

            pq.add(new Pair(nums[i], i));
            result[i - k + 1] = pq.peek().value;
        }

        return result;
    }

    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.value - this.value;
        }
    }
}