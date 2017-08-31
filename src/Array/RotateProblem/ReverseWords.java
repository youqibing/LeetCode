package Array.RotateProblem;

/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 *
 * Clarification:
 *
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWords {


    public static void main(String args[]){
        String s = "the sky is blue";
        String res = reverseWord(s);

        System.out.println(res);
    }

    private static String reverseWord(String s){
        if(s == null || s.length() ==0){
            return "";
        }

        String[] arrays = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = arrays.length-1; i>=0; i--){
            if(!arrays[i].equals("")){
                sb.append(arrays[i]).append(" ");
            }
        }

        //截取第一个单词到最后一个单词，这样就去掉了最后一个单词后面的空格
        return sb.length()==0 ? "" : sb.substring(0, sb.length()-1);
    }
}

/**
 * str＝str.substring(int beginIndex);截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
 * str＝str.substring(int beginIndex，int endIndex);截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;
 */
