package Sum.ThreeSum;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

     Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [-1, 0, 1],
     [-1, -1, 2]

     3 Sum问题是2Sum问题的变种，主要思路是：先确定一个值a，然后剩下的两个值就是temp = traget - a的2Sum问题；
     其次我们根据题意还可以知道，这里需要求得和是 0，那么可以分为两种情况：1.三个数全是0 2.其中至少一个数 < 0
 * @author dell
 *
 */
public class ThreeSum {

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4 };
        int traget = 0;

        List<List<Integer>> lists = threeSum(nums , traget);
        for(int i=0; i<lists.size(); i++){
            List<Integer> res = lists.get(i);
            System.out.println(res.get(0)+" "+res.get(1)+ " "+res.get(2));
        }
    }

    public static List<List<Integer>> threeSum(int[] numbers,int trager){
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(numbers);

        for(int left =0; left <numbers.length && numbers[left]<=0; left++){
            int mid = left+1, right = numbers.length-1;

            while(mid <right){
                int temp = trager - numbers[left];
                if(left >0 && numbers[left] == numbers[left-1]) //left左标去重
                    continue;

                if((numbers[mid] + numbers[right]) == temp){
                    int temp_mid = numbers[mid];
                    int temp_right = numbers[right];

                    lists.add(Arrays.asList(numbers[left],numbers[mid],numbers[right]));
                    //System.out.println(numbers[left]+" "+numbers[mid]+ " "+numbers[right]);

                    while(mid <right && numbers[--right] == temp_right);   //mid中标去重
                    while(mid <right && numbers[++mid] == temp_mid);      //right右标去重

                }else if((numbers[mid] + numbers[right]) < temp){
                    mid++;
                }else{
                    right--;
                }
            }
        }
        
        return lists;
    }
}









