package Comprehensive.TouTiao;

import java.util.Scanner;

/**
 * 【题目描述】给定两个长度为 n 的整数数列 A 和 B。再给定 q 组查询，每次查询给出两个整数 x 和 y，求满足 Ai >= x 且 Bi >= y 这样的 i 的数量。
 *
 输入格式
 第一行给定两个整数 n 和 q。
 第二行给定数列 A，包含 n 个整数。
 第三行给定数列 B，包含 n 个整数。
 接下来 q 行，每行两个整数 x 和 y，意义如上所述。

 输出格式
 对于每组查询，输出所求的下标数量。

 输入样例
 3 2
 3 2 4
 6 5 8
 1 1
 4 8

 输出样例
 3
 1

 数据规模
 对于 30% 的数据，1 <= n, q <= 100。
 对于 100% 的数据，1 <= n, q, Ai, Bi <= 10^5。
 */
public class QuerySequence {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int q = in.nextInt();

            int[] A = new int[n];
            int[] B = new int[n];

            for(int i=0; i<n; i++){
                A[i] = in.nextInt();
            }

            for(int i=0; i<n; i++){
                B[i] = in.nextInt();
            }

            for(int i=0; i<q; i++){
                int x = in.nextInt();
                int y = in.nextInt();
                int count =0;

                for(int j=0; j<n; j++){
                    if(A[j]>=x && B[j]>=y){
                        count ++;
                    }
                }

                System.out.println(count);

            }


        }
    }
}
