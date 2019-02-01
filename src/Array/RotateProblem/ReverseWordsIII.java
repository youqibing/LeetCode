package Array.RotateProblem;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsIII {
    public static void main(String args[]){
        String s = "Let's take LeetCode contest";
        StringBuilder sb = reverseWordIII(s);

        System.out.println(sb.toString());
    }

/*
    private static StringBuilder reverseWordIII(String s){
        int z=0;

        StringBuilder sb = new StringBuilder(s);
        sb.append(" "); //给字符串后面加一个空格，用于统一检测单词

        for(int i=0; i<sb.length();i++){
            if(sb.charAt(i) == ' '){

                for(int j=z,w=i-1; (j-z)<(i-z)/2; j++,w--){
                    char t = sb.charAt(j);
                    sb.setCharAt(j,sb.charAt(w));
                    sb.setCharAt(w,t);
                }
                z=i+1;
            }
        }

        sb.substring(0, sb.length()-2);

        return  sb;
    }
*/

    private static StringBuilder reverseWordIII(String s){
        StringBuilder res = new StringBuilder();

        String[] strings = s.split(" ");
        for(String string : strings){
            System.out.println(string);

            char[] c = new char[string.length()];
            int l = 0;
            int r = string.length() -1;

            for(int i=0; i<=string.length()>>1; i++){
                if(l<=r){
                    c[r] = string.charAt(l);
                    c[l] = string.charAt(r);
                }
                l++;
                r--;
            }

            for(int i=0; i<string.length(); i++){
                res.append(c[i]);
            }
            res.append(" ");
        }

        return res;
    }
}
