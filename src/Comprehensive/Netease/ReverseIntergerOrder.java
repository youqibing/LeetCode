package Comprehensive.Netease;

import java.util.Scanner;

/**
    链接：https://www.nowcoder.com/questionTerminal/b53bda356a494154b6411d80380295f5
    来源：牛客网

    小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
    1、将a_i放入b序列的末尾
    2、逆置b序列
    小易需要你计算输出操作n次之后的b序列。
    输入描述:

    输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
    第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。


    输出描述:

    在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
    示例1
    输入

    4
    1 2 3 4
    输出

    4 2 1 3

    这个题就是找规律,网易的题目中找规律的题还是很多的,这种题一定要在纸上写出来，找到规律之后再编码
    对于这道题来说,原数列是奇数：
        最终排出来的整数序列,从左边开始到中间, 是原数列最后一个数开始, 隔两个数一选
                         从右边开始到中间, 是原数列倒数第二个数开始, 隔两个数一取
        原数列是偶数:
        最终排出来的整数序列,左半部分, 是原数列最后一个数开始, 隔两个数一选
                         右半部分, 是原数列倒数第二个数开始, 隔两个数一取
 */
public class ReverseIntergerOrder {

    public static void main(String[] main){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }

        reverseIntergerOrder(nums);
    }

    private static void reverseIntergerOrder(int[] nums){
        int[] res = new int[nums.length];
        int j=0;
        if(nums.length %2 != 0){
            for(int i= nums.length-1; i>=0; i-=2,j++){
                res[j] = nums[i];
            }

            for(int i= 1; i<nums.length-2; i-=2, ++j){
                res[j] = nums[i];
            }
        }else {
            for(int i= nums.length-1; i>0; i-=2,j++){
                res[j] = nums[i];
            }

            for(int i= 0; i<=nums.length-2; i+=2, ++j){
                res[j] = nums[i];
            }
        }

        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }

    }
}
