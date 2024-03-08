package leetcode75.Interval;

import com.sun.org.apache.xml.internal.utils.IntVector;

import java.util.Arrays;
import java.util.Comparator;

//453.无重叠区间
/*给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。

返回 需要移除区间的最小数量，使剩余区间互不重叠 。*/
//没有思路
//官解:动规 先将区间排序 dp[i]=表示以第i个区间结尾最多能选多少个不重复的区间 O(n^2) 其实也想到了
//方法二: 贪心 理解成一天有很多活动要参加 先按活动的结束时间排序 结束时间相同的 开始晚的在前面
//尽可能参加结束时间早的 如果结束时间相同 则选择开始时间晚的 尽可能参加多的活动
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        int sum = 1, right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= right) {
                sum++;
                right = intervals[i][1];
            }
        }
        return len - sum;
    }

    public int optimize(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int right = intervals[0][1], delete = 0;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < right) {
                delete++;
            } else {
                right = intervals[i][1];
            }
        }
        return delete;
    }
}
