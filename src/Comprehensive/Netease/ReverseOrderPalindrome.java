package Comprehensive.Netease;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/0147cbd790724bc9ae0b779aaf7c5b50
 来源：牛客网

 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 现在给出一个数字序列，允许使用一种转换操作：
 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。

 输入描述:

 输入为两行，第一行为序列长度n ( 1 ≤ n ≤ 50) 第二行为序列中的n个整数item[i] (1 ≤ iteam[i] ≤ 1000)，以空格分隔。


 输出描述:

 输出一个数，表示最少需要的转换次数
 示例1
 输入

 4 1 1 1 3
 输出

 2

    这个题题目中给的条件是确定的,就是说你只能进行 "选择任意两个相邻的数,然后从序列移除这两个数,并用这两个数字的和插入到这两个数之前的位置
 (只插入一个和)"这一种操作, 因此我们就要想既然题目条件定死了,那么如何才能通过这种方法获得回文序列呢？
    回文序列的特点是前后对称,那么一般是 "W型"和 "M型",我们比较第一个和最后一个数，第一个数大，则最后一个数和倒数第二个数相加插入新数组后面;
 若第一个数小则第一个和第二个相加插入原数组 ; 若第一个和最后一个数相等,则直接删除这两个人元素
    这样一来两边才能越来越均衡。如果加的过程中始终不能平衡，那么当相加到只剩一个数时就成回文序列了。
 */
public class ReverseOrderPalindrome {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        reverseOrderPalindrome(nums);
    }

    private static void reverseOrderPalindrome(int[] nums){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }

        int count = 0;

        while(list.size() > 1){
            if(list.get(0) < list.get(list.size()-1)){
                int a = list.get(0);
                int b = list.get(1);
                list.set(0,a+b);
                list.remove(1);
                count++;

            }else if(list.get(0) > list.get(list.size()-1)){
                int a = list.get(list.size()-1);
                int b = list.get(list.size()-2);
                list.set(list.size()-2,a+b);
                list.remove(list.size()-1);
                count++;

            }else {
                list.remove(0);
                list.remove(list.size()-1);
            }
        }

        System.out.print(count);
    }
}
