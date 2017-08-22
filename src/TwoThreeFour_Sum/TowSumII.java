package TwoThreeFour_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TowSumII {
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

                list.add(Arrays.asList(nums[start],nums[end]));
                ++ start;       //没有这两句就没办法跳出这个if语句，毕竟已经等于traget
                -- end;         //了，只有如果不自减一次永远不会出现下面两个分支中的情况
            }else if(nums[start]+ nums[end] < traget){
                start++;
            }else {
                end --;
            }
        }

        return list;
    }
}
