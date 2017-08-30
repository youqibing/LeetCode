package Array.RotateProblem;

/**
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * Hint:
 * Could you do it in-place with O(1) extra space?
 *
 *
 */
public class RotateArray {
    public static void main(String args[]){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        //int[] nums = {12, 11, 10, 4, 5, 6, 7, 8, 9, 1, 2, 3};
        int k =3;

        rotateArray(nums,k);
    }

    private static void rotateArray(int[] numbers, int k){
        int temp;

        for(int i=0; i<numbers.length-1; i++){
            //System.out.println("i: "+i);
            if(k-i>0){
                temp = numbers[i];
                numbers[i] = numbers[numbers.length - k + i];
                numbers[numbers.length - k + i] = temp;

                println(numbers,i);

            }else {
                for(int j=k;j<numbers.length -1-(i-k); j++){
                    System.out.println("i: "+ i+" j: "+j);

                    if(numbers[j]>numbers[j+1]){
                        temp=numbers[j];
                        numbers[j]=numbers[j+1];
                        numbers[j+1]=temp;
                    }
                }
                println(numbers,i);
            }
        }

    }

    private static void println(int[] numbers,int i){
        System.out.println("第"+i+"趟排序：");
        for(int x=0; x<numbers.length; x++){
            System.out.print(numbers[x]+",");
        }
        System.out.println("");
    }
}
