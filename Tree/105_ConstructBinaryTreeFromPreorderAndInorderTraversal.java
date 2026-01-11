/**105. Construct Binary Tree from Preorder and Inorder Traversal
Solved
Medium
Topics - Array, Hash Table, Divide and Conquer, Tree, Binary Tree

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree. */




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
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int index = start;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        root.left = build(preorder, inorder, start, index - 1);
        root.right = build(preorder, inorder, index + 1, end);
        return root;
    }
}


