/**1160. Find Words That Can Be Formed by Characters
Solved
Easy
Topics - Mid Level, Array, Hash Table, String, Counting, Weekly Contest 150

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once for each word in words).

Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 
Constraints:
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters. */


class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];

        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            int[] copy = charCount.clone();
            String word = words[i];
            boolean valid = true;

            for (int j = 0; j < word.length(); j++) {
                if (copy[word.charAt(j) - 'a'] == 0) {
                    valid = false;
                    break;
                } else {
                    copy[word.charAt(j) - 'a']--;
                }
            }

            if (valid) {
                count += word.length();
            }
        }

        return count;
    }
}