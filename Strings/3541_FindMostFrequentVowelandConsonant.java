/*3541. Find Most Frequent Vowel and Consonant
Solved
Easy
Topics - Hash Table, String, Counting, Biweekly Contest 156

You are given a string s consisting of lowercase English letters ('a' to 'z').

Your task is to:
Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
Find the consonant (all other letters excluding vowels) with the maximum frequency.
Return the sum of the two frequencies.

Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

The frequency of a letter x is the number of times it occurs in the string.
 

Example 1:
Input: s = "successes"
Output: 6
Explanation:
The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
The output is 2 + 4 = 6.

Example 2:
Input: s = "aeiaeia"
Output: 3
Explanation:
The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
There are no consonants in s. Hence, maximum consonant frequency = 0.
The output is 3 + 0 = 3.
 

Constraints:
1 <= s.length <= 100
s consists of lowercase English letters only.*/



class Solution {
    public int maxFreqSum(String str) {
        int a=0, b=0, c=0, d=0, e=0, f=0, g=0, h=0, i=0, j=0, k=0, l=0, m=0, n=0, o=0, p=0, q=0, r=0, s=0, t=0, u=0, v=0, w=0, x=0, y=0, z=0;
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (ch == 'a') a++;
            if (ch == 'b') b++;
            if (ch == 'c') c++;
            if (ch == 'd') d++;
            if (ch == 'e') e++;
            if (ch == 'f') f++;
            if (ch == 'g') g++;
            if (ch == 'h') h++;
            if (ch == 'i') i++;
            if (ch == 'j') j++;
            if (ch == 'k') k++;
            if (ch == 'l') l++;
            if (ch == 'm') m++;
            if (ch == 'n') n++;
            if (ch == 'o') o++;
            if (ch == 'p') p++;
            if (ch == 'q') q++;
            if (ch == 'r') r++;
            if (ch == 's') s++;
            if (ch == 't') t++;
            if (ch == 'u') u++;
            if (ch == 'v') v++;
            if (ch == 'w') w++;
            if (ch == 'x') x++;
            if (ch == 'y') y++;
            if (ch == 'z') z++;
        }
        int[] vowels = {a, e, i, o, u};
        int maxVowel = vowels[0];
        for (int val : vowels) {
            maxVowel = Math.max(maxVowel, val);
        }
        int[] consonants = {b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z};
        int maxConsonant = consonants[0];
        for (int val : consonants) {
            maxConsonant = Math.max(maxConsonant, val);
        }

        return maxVowel + maxConsonant;
    }
}
