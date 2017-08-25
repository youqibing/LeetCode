package Array.TowPoint.RemoveElement;


/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter
 * what you leave beyond the new length.
 */
public class RmElementSorted {
    public static void main(String args[]){
        int[] nums = {1, 1, 2, 3, 3, 3, 5, 6, 6};
        Result res =  rmElementSorted(nums);

        int[] resNumb = res.getRes();
        System.out.println(res.getLength());
        for (int i=0 ;i<res.getLength(); i++) {
            System.out.print(resNumb[i]+",");
        }
    }

    private static Result rmElementSorted(int[] numbers){
        int z=0,j=0;
        for(int i=0; i<numbers.length; i++){

            if(i!=0 && numbers[i] == numbers[i-1]){
                numbers[j] = numbers[i];
                continue;
            }
            numbers[j++] = numbers[i];
            z++;
        }

        Result res = new Result(numbers,z);
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
