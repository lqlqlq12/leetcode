package leetcode75.Interval;

import java.util.Arrays;

//452.用最少数量的箭引爆气球
/*有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。

一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。

给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。*/
//思路:根据右边界升序排序 然后一直到不得不射箭的时候再射箭
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));
        int re = 0, len = points.length;
        for (int i = 0, boundary = Integer.MAX_VALUE; i < len; i++) {
            if (points[i][0] > boundary) {
                re++;
                boundary = points[i][1];
            } else {
                boundary = Math.min(boundary, points[i][1]);
            }
        }
        return ++re;
    }
}
