package Array.TowPoint;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * 这个题目与之前Sum问题最大的不同是，数组中的元素位置是固定的，我们不能通过排序来缩短时间，不过任然可以用双指针从左右两端逼近。
 * 题目要求是，找出可以装最大体积水的两个木板，由于水的高度是由较短的木板决定的，所以由"木板之间的距离*Min(left,right)"即可
 * 同时还需注意一点，当我们在考察两个木板和X轴围成的桶能装水的多少时，中间其他的木板就自动忽略了，不然这题就非常复杂了
 *
 * 相关博客：http://blog.csdn.net/wzy_1988/article/details/17248209
 */
public class MostWater {

    public static void main(String args[]){
        int[] nums = {-1, 0, 1, 3, -1, 4 };
        int mostWater = MostWater(nums);

        System.out.println(mostWater);
    }

    public static int MostWater(int[] hight){
        int left = 0;
        int right = hight.length -1;
        int temp = (left > right) ? right:left ; //temp表示left和right中较小的一个，也就是“短板”

        int container;
        int container_MAX = hight[temp]*(right - left); //最大桶的容量

        while(left < right){
            if(hight[left] < hight[right]){
                left ++;
            }else{
                right --;
            }

            container = Math.min(hight[left] ,hight[right])*(right - left);
            if(container > container_MAX){
                container_MAX = container;
            }
        }
        return container_MAX;
    }
}
