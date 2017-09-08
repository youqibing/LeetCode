package Array.TowPoint.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 22,

 Because nums[1] + nums[3] = 7 + 15 = 9,
 return [1, 3].

 这种解法是次优解，时间复杂度为O(N),主要步骤：1.排序 2.前后指针逼近目标值，之所以要说这中次优解，是因为之后的ThreeSum和FourSum
 问题中会有HashMap不能解决的问题~~只能用这种方法
 */

public class TwoSumII {
    public static void main(String args[]){
        int[] nums = {2, 7, 11, 15};
        int traget = 22;

        List<List<Integer>> lists = twoSum(nums,traget);
        for(int i=0; i<lists.size(); i++){
            List<Integer> res = lists.get(i);
            System.out.println(res.get(0)+" "+res.get(1));
        }
    }

    private static List<List<Integer>> twoSum(int[] nums, int traget){
        int start =0;
        int end =nums.length-1;

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        while(start < end){
            if((nums[start] +nums[end]) == traget){

                //list.add(Arrays.asList(nums[start],nums[end]));
                list.add(Arrays.asList(start,end));
                ++ start;    //没有这两句就没办法跳出这个if语句，毕竟已经等于traget
                -- end;      //了，只有如果不自减一次永远不会出现下面两个分支中的情况
            }else if(nums[start]+ nums[end] < traget){
                start++;
            }else {
                end --;
            }
        }

        return list;
    }
}
