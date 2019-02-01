package Comprehensive;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/3897c2bcc87943ed98d8e0b9e18c4666
 来源：牛客网

 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.

 输入描述:
 输入包括多组测试数据。
     每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。学生ID编号从1编到N。
     第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
     接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，
 成绩最高的是多少；当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。


 输出描述:
 对于每一次询问操作，在一行里面输出最高成绩.

 输入例子:
 5 7
 1 2 3 4 5
 Q 1 5
 U 3 6
 Q 3 4
 Q 4 5
 U 4 5
 U 2 9
 Q 1 5


 输出例子:
 5
 6
 5
 9
 * @author dell
 *
 */

public class HuaWeiMaxSocre {
    public static void main(String[] args){
        int M=0,N=0;
        int A=0,B=0;
        String C ;

        Scanner in  = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            M =in.nextInt();

            int[] score = new int[N];
            for(int i=0; in.hasNext()&& i<N; i++){
                score[i] = in.nextInt();
            }

            for(int i=0; in.hasNext()&&i<M; i++){
                C = in.next();
                A = in.nextInt();
                B = in.nextInt();

                maxScore(C,A,B,score);
            }
        }
    }

    private static void maxScore(String s,int a,int b, int[] score){
        if(s.equals("Q")){
            int j=a-1;
            int l= b-a+1;
            int[] res= new int[l];

            for(int i=0; i<l;){
                res[i++]= score[j];
                j++;
            }
            Arrays.sort(res);
            System.out.print(res[res.length-1]);
        }else {
            score[a-1] = b;
        }
    }

}














