package Comprehensive.TouTiao;

import java.util.Arrays;
import java.util.Scanner;

public class Room {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int n = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for(int i=0; i<n; i++){
                a[i] = in.nextInt();
                b[i] = a[i];
            }

            Arrays.sort(b);

            int y = b[0];   //b或者a数组中最小的数代表的是分配的轮数
            int index = 0;

            for(int i=0; i<n; i++){
                if(a[i]==y) {
                    index = i;  //判断哪个房间的人被分配了（注意与房间号差了1位）
                }
            }

            for(int i=x-1; i>=0; i--){
                a[i] = a[i]-1;
            }

            for(int i=0; i<index; i++){
                a[i] = a[i]-y;
            }

            for(int i= index+1; i<n; i++){
                a[i] = a[i]-y;
            }

            a[index] = y*n+x;

            for(int i=0; i<n; i++){
                System.out.print(a[i]);
            }

        }
    }
}
