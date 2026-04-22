/**686. Repeated String Match
Solved
Medium
Topics - Mid Level, String, String Matching

Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

Example 2:
Input: a = "a", b = "aa"
Output: 2
 
Constraints:
1 <= a.length, b.length <= 10^4
a and b consist of lowercase English letters. */


class Solution {
    public int repeatedStringMatch(String a, String b) {
        String str = a;
        int count = 1;

        while (str.length() < b.length()) {
            str += a;
            count++;
        }

        if (str.contains(b)) return count;

        str += a;
        count++;
        if (str.contains(b)) return count;

        return -1;
    }
}