package Hash;

import java.util.*;

/**
 * 这个程序演示了如何用LinkedHashMap,中的map.put(num,map.getOrDefault(num,0)+1);
 * 方法删除数组中的重复数据，保留不重复的数据 ;   以及如何用HashSet去重
 */
public class Deduplication {
    public static void main(String[] args){
        int[] nums ={1,1,2,2,3,3,4,4,5,6,6,8,9,9};
        hashMap(nums);

    }

    private static void hashMap(int[] nums){
        Map<Integer,Integer> map = new LinkedHashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);     //这里去掉+1
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){   //HashMap遍历，重要！！！
            if(entry.getValue() == 1){          //这里改为 ==0，则最后输出的结果为不重复数据即1,2,3,4,5,6,8,9
                System.out.print(entry.getKey()+",");
            }
        }

    }

    private static void hashSet(int[] nums){    //或者直接用HashSet做这件事
        HashSet<Integer> set = new HashSet<>();

        for(int n:nums){
            set.add(n);
        }

        for (Integer i : set) {
            System.out.print(i + ", ");
        }
    }
}
