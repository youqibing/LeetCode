package TwoThreeFour_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 相关博客：
 */
public class TwoSum {

    public static void main(String args[]){
        int[] nums = {2, 7, 11, 15};
        int traget = 22;
        List<Integer[]> res = twoSum(nums,traget);

        for(int i=0; i<res.size(); i++){
            Integer[] result = res.get(i);

            System.out.println(result[0]+" "+result[1]);
        }
    }

    public static List<Integer[]> twoSum(int[] numbers,int traget){
        Integer[] res = new Integer[2];
        if(numbers == null || numbers.length < 2)
            return null;

        List<Integer[]> result= new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<numbers.length; i++){
            if(map.containsKey(traget - numbers[i])){
                res[0] = traget - numbers[i];
                res[1] = i;
                result.add(res);
            }
            map.put(numbers[i] , i);
        }

        return result;
    }
}
