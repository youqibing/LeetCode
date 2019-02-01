package Hash;

import java.util.HashMap;
import java.util.Map;

public class SerachReapet {

    public static void main(String args[]){
        int[] nums = {1,2,3,2,2,2,5,4,2};

        serachReapet(nums);
    }

    private static void serachReapet(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);    //+1很重要,每次都能保留数字并统计出现的次数
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > (nums.length/2)){
                System.out.println(entry.getKey());
            }
        }
    }
}
