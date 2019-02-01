package Array.HalfSerach;

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
        int[] nums = {3, 4, 5, 6, 7, 7, 7, 7, 8, 9, 10, 11, 14};
        int[] res = {-1,-1};
        int traget = 7;

        res[0] =left(nums,traget);
        res[1] =right(nums,traget);

        System.out.print(res[0]+","+res[1]);
    }

    private static int left(int[] nums, int traget){
        int l = 0, r = nums.length - 1;
        int mid ;

        while(l < r){
            mid = l + ((r - l)>>1);
            if(nums[mid] < traget){
                l = mid + 1;
            }else {
                r = mid;    //这里没有-1是因为有 nums[mid] = traget 这种情况
            }
        }

        if(nums[l] != traget){
            return -1;
        }

        return l;
    }

    private static int right(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        int mid;

        while(l < r){
            mid = l + ((r - l)>>1) + 1;
            if(nums[mid] > target){
                r = mid -1;
            }else {
                l = mid;
            }
        }

        if(nums[r] != target){
            return -1;
        }

        return r;
    }
}
