/**131. Palindrome Partitioning
Solved
Medium
Topics - String, Dynamic Programming, Backtracking

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters. */





class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int start, String s, List<String> curr, List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                curr.add(s.substring(start, end + 1));

                backtrack(end + 1, s, curr, ans);

                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}