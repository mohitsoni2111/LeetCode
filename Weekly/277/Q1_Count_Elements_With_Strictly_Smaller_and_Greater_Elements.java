// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/

package Leetcode_Online_Judge_Solutions;

public class Count_Elements_With_Strictly_Smaller_and_Greater_Elements {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int ele : nums){
            if (ele > min && ele < max)
                count++;
        }
        return count;
    }
}
