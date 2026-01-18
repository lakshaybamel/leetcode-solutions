/**1382. Balance a Binary Search Tree
Solved
Medium
Topics - Divide and Conquer, Greedy, Tree, Depth-First Search, Binary Search Tree, Binary Tree, Weekly Contest 180

Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

Example 1:
Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

Example 2:
Input: root = [2,1,3]
Output: [2,1,3]
 
Constraints:
The number of nodes in the tree is in the range [1, 10^4].
1 <= Node.val <= 10^5 */





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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        return  createBST(inorder, 0, inorder.size() - 1);
    }

    private void getInorder(TreeNode root, ArrayList<Integer> inorder) {
        if(root == null) return;

        getInorder(root.left, inorder);
        inorder.add(root.val);
        getInorder(root.right, inorder);
    }

    private TreeNode createBST(ArrayList<Integer> inorder, int start, int end) {
        if(start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = createBST(inorder, start, mid - 1);
        root.right = createBST(inorder, mid + 1, end);

        return root;
    }
}