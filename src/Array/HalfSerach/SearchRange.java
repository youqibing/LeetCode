package Array.HalfSerach;

import java.util.List;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * 题目中要求时间复杂度是 O(log n),显然是让我们用二分查找法。
 * 同时，不同于二分插入,二分插入只需要确定一个位置(查找树上面不命中位置)这里是要确定一个范围(range),即两个边界,
 * 因此需要从 [0, mid] 和 [mid+1, nums.length-1]两个范围开始确定 left和 right,前者是向右逼近，后者是向前逼近，
 * 直到第一次碰到等于 target 的数组元素，记录下标.
 */
public class SearchRange {
    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 9, 10 };
        int[] res = {-1,-1};
        int traget = 9;

        res[0] =left(nums,traget);
        res[1] =right(nums,traget);

        System.out.print(res[0]+","+res[1]);
    }

    private static int left(int[] nums, int traget){
        int st =0, ed =nums.length-1, mid;

        while(st < ed){     //确定左边界st
            mid = st + (ed - st)/2;     //不用 mid = (st + ed) / 2 是因为后面的情况当st+ed很大时可能会产生溢出
            if(nums[mid] <traget){  //保证st不会越过任何等于target的数
                st = mid +1;    //
            }else {         //大于等于
                ed = mid ;  //数组(升序)mid下标的数大于等于 traget, 那后面的数就不用比较了
            }
        }

        if(nums[st] != traget){
            return -1;     //不存在
        }

        return st;
    }

    private static int right(int[] nums, int traget){
        int st =0, ed =nums.length-1, mid;

        while(st < ed){     //确定右边界ed
            mid = (st + (ed - st)/2) +1;  //这里用+1是为了让mid偏向右边
            if(nums[mid] >traget){
                ed = mid -1;
            }else {         //小于等于
                st = mid ;   //因为st已经确定了，所以这里实际上不会出现比target小的数了
            }
        }

        if(nums[ed] != traget){
            return -1;     //不存在
        }

        return ed;
    }

}
