package Comprehensive.Netease;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/bc62febdd1034a73a62224affe8bddf2
 来源：牛客网

 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 如果 X = 123，则rev(X) = 321;
 如果 X = 100，则rev(X) = 1.
 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
 输入描述:

 输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。


 输出描述:

 输出rev(rev(x) + rev(y))的值
 示例1
 输入

 123 100
 输出

 223
 */
public class FlipEveryBit {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int res = rev(rev(a)+rev(b));
        System.out.print(res);
    }

    /**获取一个整数每一位的数字的标准计算过程,牢记**/
    private static int rev(int n){
        int x = 0;   //反转后的数字
        while(n != 0){
            int y = n % 10; //原数字的个位数字
            x = x*10 + y;   //反转后的数字
            n = n/10;       //实现位与位之间的遍历, 将n的位数减小一位
        }

        return x;
    }
}
