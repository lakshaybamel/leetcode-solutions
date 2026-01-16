/**229. Majority Element II
Solved
Medium
Topics - Array, Hash Table, Sorting, Counting

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 
Constraints:
1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9 */




class Solution {
    public List<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int key: hm.keySet()) {
            if(hm.get(key) > nums.length/3) {
                ans.add(key);
            }
        }
        
        return ans;
    }
}