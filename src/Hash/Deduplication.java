package Hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 这个程序演示了如何用LinkedHashMap,中的map.put(num,map.getOrDefault(num,0)+1);方法删除数组中的重复数据，保留不重复的数据
 */
public class Deduplication {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();

        int[] nums ={1,1,2,2,3,3,4,4,5,6,6,8,9,9};
        deduplication(nums);

    }

    private static void deduplication(int[] nums){
        Map<Integer,Integer> map = new LinkedHashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                System.out.print(entry.getKey()+",");
            }
        }

    }
}
