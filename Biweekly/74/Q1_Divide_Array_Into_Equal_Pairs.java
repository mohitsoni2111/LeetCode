// https://leetcode.com/contest/biweekly-contest-74/problems/divide-array-into-equal-pairs/
package biweekly_74;

import java.util.Arrays;

public class Q1_Divide_Array_Into_Equal_Pairs {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;

    }
}
