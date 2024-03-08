package typical150.Interval;

import java.util.ArrayList;
import java.util.List;

//57.插入区间
/*给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）*/
//思路 就是遍历吧.... 没想到挺复杂
//正确思路:应该先判断是直接插入尾部还是头部 还挺有难度的 需要细节
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        if (len == 0) {
            return new int[][]{newInterval};
        }
        if (intervals[0][0] > newInterval[1]) {
            list.add(newInterval);
            for (int i = 0; i < len; i++) {
                list.add(intervals[i]);
            }
        } else if (intervals[len - 1][1] < newInterval[0]) {
            for (int i = 0; i < len; i++) {
                list.add(intervals[i]);
            }
            list.add(newInterval);
        } else {
            int index = 0, left = newInterval[0], right = newInterval[1];
            while (index < len && intervals[index][1] < newInterval[0]) {
                list.add(intervals[index++]);
            }
            left = Math.min(left, intervals[index][0]);
            while (index < len && intervals[index][0] <= newInterval[1]) {
                index++;
            }
            right = Math.max(right, intervals[index - 1][1]);
            list.add(new int[]{left, right});
            while (index < len) {
                list.add(intervals[index++]);
            }
        }
        int[][] re = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            re[i] = list.get(i);
        }
        return re;
    }

    public static void main(String[] args) {
        int[] re = new int[]{1, 2, 3};
        List<int[]> list = new ArrayList<>();
        list.add(re);
        for (int[] ints : list) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
        re[0] = 3;
        re[1] = 2;
        re[2] = 1;
        for (int[] ints : list) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }
}
