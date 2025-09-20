/*50. Pow(x, n)
Solved
Medium
Topics - Math, Recursion

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 
Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 

Constraints:
-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
n is an integer.
Either x is not zero or n > 0.
-10^4 <= xn <= 10^4*/


class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                return x * myPow(x, -(n + 1));
            }
            n = -n;
        }

        double halfPower = myPow(x, n / 2);
        double halfPowerSquare = halfPower * halfPower;

        if (n % 2 == 1) {
            return x * halfPowerSquare;
        }
        return halfPowerSquare;
    }
}
