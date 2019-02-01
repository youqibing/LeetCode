package Array.BigDataOperating;

/**
 * 两个字符串相加，a~Z代表0~51，52进制加法
 */
public class BigDataAddFive {
    public static void main(String args[]){
        String s1 = "abcdefg";
        String s2 = "abcd";

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);


        if((c1 == '-') && (c2 != '-')){   //我们的减法运算约定的是s1-s2
            System.out.println(Subtraction(new StringBuilder(s2).substring(1,s2.length()), s1)); //传之前得把符号去掉

        }else if((c2 == '-') && (c1 != '-')){
            System.out.println(Subtraction(s1, new StringBuilder(s2).substring(1,s2.length())));

        }else if((c1 == '-') && (c2 == '-')){   //两个都为负，转化为加法运算，最后添上加号
            System.out.println('-'+ add(s1,s2));

        }else {
            System.out.println(add(s1,s2));
        }

    }

    public static String add(String s1, String s2){
        StringBuilder result = new StringBuilder();

        String r1 = new StringBuilder(s1).reverse().toString();     //反转字符串进行高位对齐
        String r2 = new StringBuilder(s2).reverse().toString();

        int l1 = r1.length();
        int l2 = r2.length();

        int maxLen = l1 > l2 ? l1 : l2;
        int n = 0; //溢出数量
        boolean over = false;  //是否越界

        if(l1 < l2){        //高位补a,相当于10进制的补0
            for(int i=l1; i<l2; i++){
                r1 += "a";
            }
        }else {
            for(int i=l2; i<l1; i++){
                r2 += "a";
            }
        }


        for(int i=0; i<maxLen; i++){
            int sum = serchNum(r1.charAt(i)) + serchNum(r2.charAt(i));
            sum = sum + n;

            if(sum >= 52){    //逢52进1
                if(i == maxLen - 1){    //已经计算到最后一位了
                    over = true;
                }

                n = 1;  //溢出了
                result.append(serchChar(sum - 52));
            }else {
                n = 0;  //没溢出
                result.append(serchChar(sum));
            }
        }


        //如果溢出的话表示位增加了,高位进1
        if(over){
            result.append(serchChar(n));
        }

        return result.reverse().toString();
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

        for(int i=0; i<result.length; i++){  //用反转后的字符串开始做运算，先将每一位转化成52进制类型
            int int521 = i < l1 ? serchNum(s1.charAt(i)) : 0;
            int int522 = i < l2 ? serchNum(s2.charAt(i)) : 0;
            if(sign == '+'){            //如果最终为+，说明s1比s2大，直接int1 - int522
                result[i] = int521 - int522;
            }else {                     //如果最终为-，说明s2比s1大，用int2 - int521。只有这样处理最终借位的时候高位才能为正。
                result[i] = int522 - int521;
            }
        }

        for(int i=0; i<maxlenth-1; i++){    //reult[]数组中，某一位小于1，则高位借1，低位补52
            if(result[i] < 0){
                result[i+1] -= 1;
                result[i] += 52;
            }
        }

        StringBuilder resbuilder = new StringBuilder();

        if(sign == '-'){
            resbuilder.append("-");
        }

        boolean flag = true;
        for(int i=maxlenth-1; i>=0; i--){
            if(result[i] == 0 && flag){     //去掉高位的0
                continue;
            }else {
                flag = false;
            }

            resbuilder.append(serchChar(result[i]));    //转化为字符
        }

        if(resbuilder.toString().equals("")){
            return "a";
        }


        return resbuilder.toString();
    }


    public static int serchNum(char c){
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return s.indexOf(c);
    }

    public static char serchChar(int n){
        char[] num = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        return num[n];
    }





}
