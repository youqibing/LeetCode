package Array.Intervals;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * 数轴覆盖问题, 将各条线段的start按从小到大排序，然后依次比较每条线段的end，看是否被前一段覆盖即可。
 * 这个题主要要掌握Comparator接口的用法, 非常有用！
 */
public class MergeIntervals {

    public static void main(String[] args){

        List<Interval> list = new ArrayList<>();

        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);

        mergeIntervals(list);
    }

    private static void mergeIntervals(List<Interval> intervals){
        if(intervals == null || intervals.size()<=1){
            return ;
        }

        //Collections.sort(intervals, new IntervalsComparator());
        intervals.sort(new IntervalsComparator());

        List<Interval> result = new ArrayList<>();
        Interval pre = intervals.get(0);

        for(int i=1; i<intervals.size(); i++){  //注意i从1开始
            Interval curt = intervals.get(i);
            if(curt.start <= pre.end){   //前一个(pre)的end值改变,相当于把两个区间合并,此时last还是0,curr循环一次变为2，相当于第0个和
                pre.end = Math.max(pre.end, curt.end); //第2个比较,此时直接执行下面的else并将last(合并区间后的第一个)添加到结果返回值中
            }else {
                result.add(pre);
                pre = curt;    //指针后移一位,比较2和3
            }
            System.out.print("["+pre.start+","+pre.end+"]");
        }

        result.add(pre);
    }



    static class IntervalsComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval a, Interval b) {
            /*
            if(a.start < b.start){
                return -1;
            }else if(a.start > b.start){
                return 1;
            }else {
                return 0;
            }
            */
            return a.start - b.start;   //源码默认 a - b > 0 ; a - b < 0 ; a - b = 0  满足这三个条件为升序
        }
    }





    static class Interval {
      int start;
      int end;
      Interval() {
          start = 0; end = 0;
      }
      Interval(int s, int e) {
          start = s; end = e;
      }

    }
}
