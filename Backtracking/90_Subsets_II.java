/**90. Subsets II
Solved
Medium
Topics - Array, Backtracking, Bit Manipulation

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10 */


class Solution {

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> res) {
        res.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, res);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), res);
        return res;
    }
}
