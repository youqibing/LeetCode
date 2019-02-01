package Array.BigDataOperating;

/**
 * 这种情况是大数相加中比较全面的一种情况，我们要判断相加的两个数的正负。
 * 如果为两个整数，则直接相加
 * 如果为一正一负，则为大数相减
 * 如果为两个负数，则先保留负号，实际上也是大数相加
 *
 * char类型转为int类型：9 = '9'-'0'
 * 如果把char直接强制转为int的时候，jvm会把char当成ASCII编码来处理,(int)'9' = 57
 */
public class BigDataSubtraction {
    public static void main(String args[]){
        String s1 = "999999999";
        String s2 = "-9999999";

        System.out.println(Subtraction(s1, new StringBuilder(s2).substring(1,s2.length()))); //传之前得把符号去掉
    }

    public static String Subtraction(String s1, String s2){

        String r1 = new StringBuilder(s1).reverse().toString();
        String r2 = new StringBuilder(s2).reverse().toString();

        int l1 = r1.length();
        int l2 = r2.length();

        int maxlenth = l1 > l2 ? l1 : l2;
        int result[] = new int[maxlenth];
        char sign = '+';    //表示结果的正负

        if(l1 < l2){    //这个if语句块中主要是把最终结果为负的情况找出来
            sign = '-';
        }else if(l1 == l2){
            int i = l1 - 1;
            while(i > 0 && r1.charAt(i) == r2.charAt(i)){   //注意这里是从高位向低位判断
                i--;
            }
            if(r1.charAt(i) < r2.charAt(i)){    //在两者长度相等的情况下，一旦减数高位有一位大于被减数，则为负
                sign = '-';
            }
        }

        for(int i=0; i<result.length; i++){  //用反转后的字符串开始做运算，先将每一位转化成Int类型
            int int1 = i < l1 ? (s1.charAt(i) -'0') : 0;
            int int2 = i < l2 ? (s2.charAt(i) -'0') : 0;
            if(sign == '+'){            //如果最终为+，说明s1比s2大，直接int1 - int2
                result[i] = int1 - int2;
            }else {                     //如果最终为-，说明s2比s1大，用int2 - int1。只有这样处理最终借位的时候高位才能为正。
                result[i] = int2 - int1;
            }
        }

        for(int i=0; i<maxlenth-1; i++){    //reult[]数组中，某一位小于1，则高位借1，低位补10
            if(result[i] < 0){
                result[i+1] -= 1;
                result[i] += 10;
            }
        }

        StringBuilder resbuilder = new StringBuilder();

        if(sign == '-'){
            resbuilder.append("-");
        }

        boolean flag = true;
        for(int i=maxlenth-1; i>=0; i--){
            if(result[i] == 0 && flag){
                continue;
            }else {
                flag = false;
            }

            resbuilder.append(result[i]);
        }

        if(resbuilder.toString().equals("")){
            return "0";
        }


        return resbuilder.toString();
    }
}
