package Comprehensive.TouTiao;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/5786ab19844446f8b3de155cf39aeaa3
 来源：牛客网

 【题目描述】按数组的形式给出函数f(x)的取值，即数组A的A[0]元素为f(0)的取值，数组的取值都为整数，函数在每个点都是严格单调递增或者严格递减
 （即A[i-1] != A[i] != A[i+1]），要求找出最宽的先上升后下降的区间（这个区间内函数的值必须先上升到一个点然后下降，
 区间的上升段和下降段长度必须都大于0）。
 1. 如果找到符合条件的最大区间输出数组对应的左右下标（保证只有一个最大区间）
 2. 找不到那么输出-1 -1

 输入格式
 n
 n长度的整数数组

 输出格式
 区间的范围

 输入样例
 10
 1 3 1 2 5 4 3 1 9 10
 输出样例
 2 7

 数据规模
 对于 100% 的数据，1 <=n <=10, 000, 000
 */
public class RiseSequence {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n];

            for(int i=0; i<n; i++){
                nums[i] = in.nextInt();
            }

            int[] left = new int[n];
            for(int i=1; i<n; i++){
                if(nums[i] > nums[i-1]){
                    left[i] = left[i-1] + 1;
                }
            }

            int[] right = new int[n];
            for(int i= n-2; i>=0; i--){
                if(nums[i] > nums[i+1]){
                    right[i] = right[i+1] + 1;
                }
            }

            int ll = 0;
            int rr = 0;
            int max = 0;
            for(int i=0; i<n; i++){
               if(max < (right[i] + left[i])){
                   max = right[i] + left[i];
                   ll = i - left[i];
                   rr = i + right[i];
               }
            }

            System.out.print(ll + " " + rr);
        }
    }
}
