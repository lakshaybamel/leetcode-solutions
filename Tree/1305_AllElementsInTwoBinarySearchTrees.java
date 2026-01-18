/**1305. All Elements in Two Binary Search Trees
Solved
Medium
Topics - Tree, Depth-First Search, Binary Search Tree, Sorting, Binary Tree, Weekly Contest 169

Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 
Constraints:
The number of nodes in each tree is in the range [0, 5000].
-10^5 <= Node.val <= 10^5 */





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                ans.add(list1.get(i++));
            } else {
                ans.add(list2.get(j++));
            }
        }

        while (i < list1.size()) ans.add(list1.get(i++));
        while (j < list2.size()) ans.add(list2.get(j++));

        return ans;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
