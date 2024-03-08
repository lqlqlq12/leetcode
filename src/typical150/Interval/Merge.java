package typical150.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//56.合并区间
/*以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。*/
public class Merge {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0 || len == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int begin = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{begin, end});
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{begin, end});
        int[][] re = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            re[i] = list.get(i);
        }
        return re;
    }
}
