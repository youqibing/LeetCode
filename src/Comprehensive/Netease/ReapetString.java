package Comprehensive.Netease;

import java.util.Scanner;

public class ReapetString {

    /**
     * 思路:数组中所有相邻的数相乘等于4的倍数，所有相邻的数相乘得是偶数(同时4为其中一个因子),那么
     * 根据 “奇数*偶数=偶数”的原则,要能排成满足题意的数列，则：
     *
     *  原数列有奇数个，则偶数 = 奇数 -1;
     *  原数列有偶数个，则偶数 = 奇数;
     *
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        reapetString(s);
    }


    private static void reapetString(String string){
        int j=1;
        int x=0;
        double res =0;

        for(int i=1; i<string.length(); i++){
            if(string.charAt(i) != string.charAt(i-1)){
                j++;    //统计应该除以多少
            }
        }

        int[] count = new int[j];  //创建一个用于保存各段重复数字个数的数组
        for(int i =0; i<count.length; i++){
            count[i] =1;    //至少为1个,因此每位初始化为1
        }

        for(int i=1; i<string.length(); i++){
            if(string.charAt(i) == string.charAt(i-1)){
                count[x]++; //重复,则该位加1
            }else {
                x++;    //不重复,则数组向后移动一位,统计下一段
            }
        }


        for (int a : count) {
            res = res + a;
        }
        res = res/j;
        System.out.print(res); //计算平均值

    }
}
