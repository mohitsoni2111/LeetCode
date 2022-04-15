// https://leetcode.com/contest/biweekly-contest-74/problems/maximize-number-of-subsequences-in-a-string/
package biweekly_74;

public class Q2_Maximize_Number_of_Subsequences_in_a_String {
    public long maximumSubsequenceCount(String text, String pattern) {
        long count = 0, count1 = 0, count2 = 0;
        for (char c : text.toCharArray()) {
            count += c==pattern.charAt(1) ? count1 : 0;
            count1 += c==pattern.charAt(0) ? 1 : 0;
            count2 += c==pattern.charAt(1) ? 1 : 0;
        }
        return count+Math.max(count1, count2);
    }
}
