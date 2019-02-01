package Comprehensive;

import java.util.Scanner;
/**
 * 食堂有一张靠墙的长桌（只有面向墙的一排座位），独自来吃饭的同学都喜欢坐在这里。这长桌有一个不成文的规定：来的人都喜欢独处，不会挨着其他人吃饭。
 现在长桌上已经有一些各自独处的同学，这时又有一群人过来用餐。不知道新来的同学能不能都遵循不成文的规定，找到左右无人的座位呢？

 输入
 包括2个参数：
 一个字符串table，表示长桌（由字符'1'和'0'组成，每个字符代表一个座位，'1'代表该座位有人，'0'代表该座位为空），table长度<10000；
 一个正整形数n，表示新来就餐人数，0<n<10000。
 输出
 一个布尔值，如果能够安排下所有新来的同学，返回true；否则返回false

 样例输入
 1001
 1
 10001
 1
 10001
 2
 样例输出
 false
 true
 false

 Hint
 样例解析1:
 长桌只有中间两个空位，新来的同学无论坐哪个，都会挨着先来的同学

 样例解析2：
 新来的同学可以坐最中间的位置

 样例解析3：
 有2个新来的同学，中间的3个空位也安排不下了
 */
public class XiaoMiVacancy {

    /******************************开始写代码******************************/
    static boolean fun(String table, int n) {

        /**
         * 思路：其实这就是找连续的0的个数：
         * 0不间断时：
         *    连续0=3,可容纳1人  010
         *    连续0=5,可容纳2人  01010
         *    连续0=7,可容纳3人  0101010
         *    ...
         *    因此可以得出规律：0不间断时,容纳n人,需要2n+1个连续的0
         * 一旦间断，则需要重新开始统计,重复上述步骤
         */

        //System.out.println(n);
        char[] nums = new char[table.length()];
        for(int i=0; i<table.length(); i++){
            nums[i] = table.charAt(i);
            //System.out.print(nums[i]);
        }

        int x = 1;
        int p = 0;
        int y = 0;
        //System.out.print(x);

        for(int i=1; i<nums.length;i++){
            if(nums[i] == nums[i-1] && nums[i]=='0'){
                x++;
                //System.out.println(x);
            }else {
                if(x>=3){
                    p = (x-1)/2;
                    //System.out.println("p:"+p);
                    y += p;
                    //System.out.println("y:"+y);
                    x = 0;
                }


            }
        }
        //System.out.println("n:"+n);
        //System.out.println(y >= n);

        return y >= n;

    }


    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _table;
        try {
            _table = in.nextLine();
        } catch (Exception e) {
            _table = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = fun(_table, _n);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
