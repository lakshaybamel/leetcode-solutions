/*52. N-Queens II
Solved
Hard
Topics - Backtracking

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.


// Diagram for N-Queens algorithm:
// https://assets.leetcode.com/uploads/2020/11/13/queens.jpg


Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1
 
Constraints:
1 <= n <= 9*/


class Solution {

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    private void nQueens(char[][] board, int row, int[] count) {
        if (row == board.length) {
            count[0]++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1, count);
                board[row][j] = 'x';
            }
        }
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = 'x';

        int[] count = new int[1];
        nQueens(board, 0, count);
        return count[0];
    }
}
