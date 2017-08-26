package Array.TowPoint.RemoveElement;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 * 本题要求最多可以有两个重复的数字，并且是排好序的，和上一题一样，可以用 "numbers[i] == numbers[i-1]"判断重复，不同的是这里
 * 我们需要设置一个Z变量来统计重复的此时，z>=2时再 continue;
 */
public class RmElementSortedII {
    public static void main(String args[]){
        int[] nums = {1, 1, 1, 2, 3, 3, 3, 5, 6, 6,6};
        rmElementSortedII(nums);
    }

    private static void rmElementSortedII(int[] numbers){
        int j=0,z=0,x=0;

        for(int i=0; i<numbers.length; i++){
            if(i!=0 && numbers[i] == numbers[i-1]){

                numbers[j] = numbers[i];
                z++;

                if(z >=2 ){
                    z =0;
                    continue;
                }
            }
            numbers[j++] = numbers[i];
            x++;
        }
        for(int i=0;i< x; i++){
            System.out.print(numbers[i]+",");
        }
    }
}
