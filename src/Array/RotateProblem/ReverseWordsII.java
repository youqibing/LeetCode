package Array.RotateProblem;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?
 *
 * 本题的思路就是，先逐个单词交换，然后把整个字符串对换一下。这个题说的不能用额外额空间，个人感觉这个char t肯定是要用的，
 * 不然按根本没办法交换，以及，这里搞成 StringBuilder 包装一下是为了替换特定位置的字符
 */
public class ReverseWordsII {
    public static void main(String args[]){
        String s = "the sky is blue";
        StringBuilder sb =reverseWordII(s);

        System.out.println(sb.toString());
    }


    private static StringBuilder reverseWordII(String s){

        StringBuilder sb = new StringBuilder(s);
        sb.append(" ");

        int z = 0;

        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == ' '){
                for(int l=z, r=i-1; l<=(l+r)/2; l++, r--){
                    char t = sb.charAt(l);
                    sb.setCharAt(l,sb.charAt(r));
                    sb.setCharAt(r,t);
                }
                z=i+1;
            }
        }

        sb.substring(0,sb.length()-2);

        for(int i=0, j=sb.length()-1; i<sb.length()/2; i++, j--){
            char t = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j,t);
        }

        return sb;

    }
}
