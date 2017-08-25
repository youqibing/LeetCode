package Array.TowPoint.RemoveElement;

import java.util.List;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class rmElement {
    public static void main(String args[]){
        int[] nums = {3, 2, 2, 3};
        int traget = 3;
        Result res = element(nums,traget);

        int[] resNumb = res.getRes();
        System.out.println(res.getLength());
        for (int aResNumb : resNumb) {
            System.out.print(aResNumb+",");
        }

    }

    private static Result element(int[] numbers, int traget){
        int j=0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == traget){
                numbers[j] = numbers[i];
                j++;
            }
        }
        Result res = new Result(numbers,j);
        return res;
    }

    private static class Result{
        private int[] res;
        private int length;

        private Result(int[] res, int length){
            this.length = length;
            this.res = res;
        }

        private int[] getRes(){
            return res;
        }

        private int getLength(){
            return length;
        }
    }
}
