package Array.TowPoint.RemoveElement;


/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter
 * what you leave beyond the new length.
 *
 * 这道题跟之前拿到同样，不能用额外的空间，只能用原数组储存，人额按用两个游标 i，j来便利并保存目标数组(Z是用来计数长度的)。比较好的一点是，
 * 题目中给出的是排好序的数组，此时重复的数肯定是连在一起的，因此可以用numbers[i] == numbers[i-1]判断是否发生重复
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

        int j = 1;
        for(int i=1; i<numbers.length-1; i++){
            if(numbers[i] != numbers[i-1]){
                numbers[j] = numbers[i];
                j++;
            }
        }

        Result res = new Result(numbers, j);
        return  res;
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
