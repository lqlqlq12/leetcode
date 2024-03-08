package hot100;

import java.util.*;

//合并区间
/*以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 */
//哈希表法 不对 因为题意要求合并重叠的区间 [1,4][5,6]没有重叠不应该合并
//先排序再合并
public class Merge {

    //哈希
    public int[][] hashMethod(int[][] intervals) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int len = intervals.length;
        List<int[]> re = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            min = Math.min(min, start);
            max = Math.max(max, end);
            for (int j = start; j <= end; j++) {
                set.add(j);
            }
        }
        int left, right;
        for (left = min, right = min; right <= max; right++) {
            if (!set.contains(right)) {
                if (right > left) {
                    int[] t = new int[]{left, right - 1};
                    re.add(t);
                }
                left = right + 1;
            }
        }
        if (set.contains(right - 1)) {
            re.add(new int[]{left, right - 1});
        }
        return re.toArray(new int[1][1]);
    }


    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        int len = intervals.length;
        List<int[]> re = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if(intervals[i][0]<=right){
                right=Math.max(intervals[i][1],right);
            }
            else{
                re.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }
        }
        re.add(new int[]{left,right});
        return re.toArray(new int[1][1]);
    }


}
