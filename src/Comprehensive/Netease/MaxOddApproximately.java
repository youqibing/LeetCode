package Comprehensive.Netease;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/49cb3d0b28954deca7565b8db92c5296
 来源：牛客网

 小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题： 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
 现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
 例如： N = 7
 f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
 小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。
 输入描述:

 输入一个整数N (1 ≤ N ≤ 1000000000)


 输出描述:

 输出一个整数，即为f(1) + f(2) + f(3).......f(N)
 示例1
 输入

 7
 输出

 21

 这个题的思路:如果N是一个奇数,则最大奇约数就是自己;如果是偶数,则不断地给他除2,得到的第一个奇数就是所求解
 */
public class MaxOddApproximately {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        maxOddFactor(in.nextInt());
    }

    private static void maxOddFactor(int n){
        int count = 0;


        /**求一个数因此(不包括1和自己)的标准算法**/
        if(n == 0){
            return;
        } else if(n == 1 || n == 2){
            System.out.println("n");
            ++count;
        }else {
            for(int i=2; i<=Math.sqrt(n); i++){
                if(n % i == 0){
                    System.out.print(i+" ");
                    System.out.print(n/i+" ");
                    count += 2;
                }
            }
        }
        System.out.println(" ");
        System.out.println(count);
    }
}
