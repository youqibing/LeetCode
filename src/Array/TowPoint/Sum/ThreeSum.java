package Array.TowPoint.Sum;

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
        for (List<Integer> res : lists) {
            System.out.println(res.get(0) + " " + res.get(1) + " " + res.get(2));
        }
    }

    private static List<List<Integer>> threeSum(int[] numbers,int trager){
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(numbers);  // -4，-1，-1，0, 1, 2

        for(int left =0; left <numbers.length -3 && numbers[left]<=0; left++){
            int mid = left+1, right = numbers.length-1;

            if(left >0 && numbers[left] == numbers[left-1] )
                continue;

            while(mid <right){
                int temp = trager - numbers[left];
                //if(left >0 && numbers[left] == numbers[left-1])   //left去重不能放在这里，因为left去重的目的是为了让left重复时不
                //    continue;       //进入下面这个while循环，此时mid和right就没有必要判断了. 如果放在这里，结果就是当left=1，即第一个
                                //-1对应循环时,left=1,mid=2,right=5, temp =1, 在while循环中会将两个正确解确定出来[-1, 0, 1],[-1, -1, 2]
                // 然后出while之后，left++得2(对应值为第二个-1),此时mid=3,right=5,仍然进入while循环，并执行left去重判断，发现这里重复，
                //执行continue出while循环，这时left++得3,mid=4,right=5,仍然进while()循环,temp=0,while循环中没有满足题意的解，并且会
                //执行right--是的right=left=4,出while循环. for循环中,left++得4,mid=5,right=5,不进入while循环，在执行一个for循环，
                //按理说，left <numbers.length -3 && numbers[left]<=0，会结束循环，但是放在这里确实会卡死程序~~迷

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









