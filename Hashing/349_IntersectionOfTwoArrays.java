/**349. Intersection of Two Arrays
Solved
Easy
Topics - Array, Hash Table, Two Pointers, Binary Search, Sorting

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 
Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000 */





class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            hs.add(nums1[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            if (hs.contains(nums2[i])) {
                list.add(nums2[i]);
                hs.remove(nums2[i]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
