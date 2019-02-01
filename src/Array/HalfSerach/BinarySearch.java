package Array.HalfSerach;

public class BinarySearch {

    public static void main(String[] args){

        int[] nums = {2,3,4,6,8,9,10};
        int dex = 9;
        int res = result(nums, dex);
        System.out.println(res);
    }

    private static int result(int[] nums, int dex){
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + ((high - low)>>1); //不用mid=(high+low)/2 是因为后面的情况当high+low很大时可能会产生溢出
            if(dex == nums[mid]){
                return mid;
            }else if(dex < nums[mid]){
                high = mid -1;
            }else {
                low = mid +1;
            }
        }

        return -1;
    }


}
