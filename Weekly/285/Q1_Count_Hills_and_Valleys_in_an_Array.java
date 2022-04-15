// https://leetcode.com/contest/weekly-contest-285/problems/count-hills-and-valleys-in-an-array/
package weekly_285;

public class Q1_Count_Hills_and_Valleys_in_an_Array {
    public int countHillValley(int[] nums) {
        int count=0;
        for(int i=1; i<nums.length-1; i++) {
            if(nums[i-1] < nums[i]) {
                int j = i+1;
                for(; j < nums.length && nums[i]==nums[j]; j++);
                if(j< nums.length && nums[i]> nums[j])
                    count++;

                i = j-1;
            }
            if(nums[i-1] > nums[i]) {
                int j = i+1;
                for(; j < nums.length && nums[i]==nums[j]; j++);
                if(j< nums.length && nums[i] < nums[j])
                    count++;

                i = j-1;
            }
        }
        return count;
    }
}
