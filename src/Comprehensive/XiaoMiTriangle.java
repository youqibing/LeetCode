package Comprehensive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 我们设计了一个整数三角形，三角形的每一行都比上面一行多出一个数字（第1行有1个数字，第2行有2个数字，以此类推）；而每个数字，都等于它上方（如果有的话）与左上方两个数字之和，如下面所示：
 第1行：1
 第2行：1 1
 第3行：1 2 1
 第4行：1 3 3 1
 第5行：1 4 6 4 1
 第6行：1 5 10 10 5 1
 ...
 ...
 现在给你一个数，请算出它最开始出现在第几行。
 输入
 一个正长整形数，保证为长整形的正数
 输出
 这个数最开始出现的行数

 样例输入
 1
 4
 10
 样例输出
 1
 5
 6
 */
public class XiaoMiTriangle {

    /******************************开始写代码******************************/
    static long fun(long x) {
        /**
         * 思路：找规律题,每一行都是一个回文序列,且每一行的和遵循：
         *      2^0, 2^1, 2^2, 2^3, 2^4, 2^5...
         *       1    2    3    4    5    6
         *  因此直接可以把每一行的数推出来
         */

        int line = 1;   //行号

        if(x==1){
            return 1;
        }else {
            while(true){
                ++line;
                long[] nums = new long[line];

                for(int i=0;i<(line/2); i++){
                    nums[i]= (i+1)*(line-1);
                    System.out.println(nums[i]);
                }

                for(int i=0;i<(line/2); i++){
                    if(nums[i] == x){
                        return line;
                    }
                }

            }

        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;

        long _x;
        _x = Long.parseLong(in.nextLine().trim());

        res = fun(_x);
        System.out.println(String.valueOf(res));

    }
}
