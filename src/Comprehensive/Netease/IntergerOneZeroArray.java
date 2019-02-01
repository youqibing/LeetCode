package Comprehensive.Netease;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/3fbd8fe929ea4eb3a254c0ed34ac993a
 * 来源：牛客网
 *
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 *

 输入描述:

 输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'


 输出描述:

 输出一个整数,表示最长的满足要求的子串长度。
 示例1
 输入

 111101111
 输出

 3
 *
 */
public class IntergerOneZeroArray {
    private static int longest=1;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        oneZeroArray(string);
    }

    private static void oneZeroArray(String string){
        int nums=1;

        for(int i=1; i<string.length(); i++){
            if(string.charAt(i) != string.charAt(i-1)){
                nums++;
                longest = nums > longest ? nums : longest;
            }else {
                nums =1;
            }
        }
        System.out.print(longest);
    }
}
