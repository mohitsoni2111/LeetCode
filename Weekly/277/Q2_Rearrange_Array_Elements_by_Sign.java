// https://leetcode.com/problems/rearrange-array-elements-by-sign/
package Leetcode_Online_Judge_Solutions;

public class Q2_Rearrange_Array_Elements_by_Sign {

    /*
    Input: nums =   [3,1,-2,-5,2,-4]
    Output:         [3,-2,1,-5,2,-4]
     */

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pi = 0, ni = 1;
        int[] ans = new int[n];

        for (int ele : nums){
            if (ele >= 0){
                ans[pi] = ele;
                pi += 2;
            }
            else {
                ans[ni] = ele;
                ni += 2;
            }
        }

        return ans;
    }
}
