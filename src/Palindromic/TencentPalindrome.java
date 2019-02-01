package Palindromic;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/28c1dc06bc9b4afd957b01acdf046e69
 来源：牛客网

 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 输出需要删除的字符个数。

 输入描述:

 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.



 输出描述:

 对于每组数据，输出一个整数，代表最少需要删除的字符个数。


 输入例子:
 abcda
 google


 输出例子:
 2
 2
 * @author dell
 *
 * 这道题主要用DP来解最长回文  "子序列" 的问题
 *
 */

public class TencentPalindrome {
    private static int length ;
    private static char[] chars ;	//原数组
    private static char[] charsReverse ;	 //翻转数组
    private static int[][] dp ;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            StringBuilder sb = new StringBuilder(in.nextLine());

            length =sb.length();
            chars = new char[length];
            charsReverse = new char[length];
            dp = new int[length+1][length+1];

            for(int i=0; i<length ; i++){
                chars[i] = sb.charAt(i);
            }
            charsReverse = reverse(chars , chars.length);
        }
        in.close();

        result();	//得出需要删除几个数
        print(dp, chars, charsReverse, chars.length,  charsReverse.length);	 //打印出回文序列（或者说最长子序列）
    }

    private static void result(){
        for(int i =0; i< length; i++){
            for(int j =0; j<length; j++){
                if(chars[i] == charsReverse[j]){
                    dp[i+1][j+1] = dp[i][j] +1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        System.out.println("");
        System.out.println(length - dp[length][length]);
    }

    //打印LCS序列
    public static void print(int[][] arr, char[] c, char[] cr, int i, int j){
        if(i==0 || j==0)
            return;
        if(c[i-1]==cr[j-1]){
            System.out.print(c[i-1]+" ");
            print(arr, c, cr, i-1, j-1);
        }else if(arr[i-1][j] >= arr[i][j-1]){
            print(arr, c, cr, i-1, j);
        }else{
            print(arr, c, cr, i,j-1);
        }
    }

    //翻转字符串
    private static char[] reverse(char[] c, int n){
        char[] cr = new char[n];
        for(int i=0; i<n; i++){
            cr[i] = c[n-i-1];
        }
        return cr;
    }
}

/**
 * 测试用例:

 zgtklhfzomzjckwmluvivvcmhjrwkuvcjrxojobpdedpamdshcwwsetfbacvonecrdvugeibglvhxuymjvoryqjwullvzglqazxrdmczyvbgakjagttrezmvrlptiwoqkrtxuroeqmryzsgokopxxdpbejmtwvpnaqrgqladdszhdwxfckmewhdvihgvacueqhvwvjxoitlpfrckxkuksaqzjpwgoldyhugsacflcdqhifldoaphgdbhaciixouavqxwlghadmfortqacbffqzocinvuqpjthgekunjsstukeiffjipzzabkuiueqnjgkuiojwbjzfynafnlcaryygqjfixaoeowhkxkbsnpsvnbxuywfxbnuoemxynbtgkqtjvzqikbafjnpbeirxxrohhnjqrbqqzercqcrcswojyylunuevtdhamlkzqnjrzibwckbkiygysuaxpjrgjmurrohkhvjpmwmmtpcszpihcntyivrjplhyrqftghglkvqeidyhtmrlcljngeyaefxnywpfsualufjwnffyqnpitgkkyrbwccqggycrvoocbwsdbftkigrkcbojuwwctknzzmvhbhbfzrqwzllulbabztqnznkqdyoqnrxhwavqhzyzvmmmphzxbikpharseywpfsqyybkynwbdrgfsaxduxojcdqcjuaywzbvdjgjqtoffasiuhvxcaockebkuxpiomqmtvsqhnyxfjceqevqvnapbk

 输出为：516
 */
