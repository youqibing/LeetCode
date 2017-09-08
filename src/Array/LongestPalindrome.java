package Array;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 * Example:
 *
 * Input: "cbbd"
 *
 * Output: "bb"
 *
 *      这种解法是 "最长回文子串" 问题中最合理的一种解法，其核心思路是 "中心扩散",外层循环是遍历数组中的每个元素,并以他为中心向两边扩散,比较两边的
 * 元素是否相等，如果不相等或者到两端了，就停止以这个元素为中心的扩散比较,而向后移动一位为中心向两边扩散。每次比较得出的最长回文子串存在一个全局
 * 变量longest中,用于和下一次作比较,从而找出最长的子串。
 *      这里需要注意的是，我要考虑 "奇数" 和 "偶数"个字母以某个字母为中心对称两种情况 ,奇数时中间那个字母是多出来的,偶数的话中间两个字母也是对称的
 */
public class LongestPalindrome {
    private static String longest="";

    public static void main(String[] args){
        String s = "babad";
        longestPalindrome(s);
    }

    private static void longestPalindrome(String s){

        if(s.isEmpty()||s.length() == 1){
            return;
        }

        for(int i=0; i<s.length(); i++){
            helper(s,i,0);  //处理奇数个字母对称的情况
            helper(s,i,1);  //处理偶数个字母对称的情况
        }

        System.out.print(longest);
    }

    private static void helper(String s, int idx, int offset){
        int left = idx;
        int right = idx+offset;

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        String currLongest  = s.substring(left+1,right);    //截出当前最长的子串

        if(currLongest .length() > longest.length()){       //判断是否比全局最长还长
            longest = currLongest ;
        }
    }
}
