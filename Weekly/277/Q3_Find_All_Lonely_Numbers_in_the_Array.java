// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
package Leetcode_Online_Judge_Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q3_Find_All_Lonely_Numbers_in_the_Array {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        for (int ele : nums){
            if (map.get(ele) > 1 || map.containsKey(ele - 1) || map.containsKey(ele + 1))
                continue;

            ans.add(ele);
        }
        return ans;
    }
}
