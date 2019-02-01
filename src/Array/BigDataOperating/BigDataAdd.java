package Array.BigDataOperating;

/**
 * 大数相加，这里是最简单的一种情况，也就是相加的两个数都是正数
 *
 * 还有我们要知道，Java中int的范围是 -2^31 ~ 2^31-1，也即是只能便是32位整数，
 * 而String的长度由其源码决定：
 *  private final char value[];
 *  private final int offset;
 *
 *  也就是说，String中也是用过char类型数组储存字符，而可储存的长度为int的大小，也就是2^32位的字符
 */
public class BigDataAdd {

    public static void main(String args[]){
        String s1 = "999999999";
        String s2 = "9999999";
        System.out.println(add(s1,s2));
    }

    public static String add(String s1, String s2){
        StringBuilder result = new StringBuilder();

        String r1 = new StringBuilder(s1).reverse().toString();
        String r2 = new StringBuilder(s2).reverse().toString();

        int l1 = r1.length();
        int l2 = r2.length();

        int maxLen = l1 > l2 ? l1 : l2;
        int n = 0; //溢出数量
        boolean over = false;  //是否越界

        if(l1 < l2){        //高位补0
            for(int i=l1; i<l2; i++){
                r1 += "0";
            }
        }else {
            for(int i=l2; i<l1; i++){
                r2 += "0";
            }
        }

        for(int i=0; i<maxLen; i++){
            int sum = Integer.parseInt(r1.charAt(i)+"")
                    + Integer.parseInt(r2.charAt(i)+"");
            sum = sum + n;

            if(sum >= 10){
                if(i == maxLen - 1){    //已经计算到最后一位了
                    over = true;
                }

                n = 1;  //溢出了
                result.append(sum - 10);
            }else {
                n = 0;  //没溢出
                result.append(sum);
            }
        }

        //如果溢出的话表示位增加了,高位进1
        if(over){
            result.append(n);
        }

        return result.reverse().toString();
    }
}
