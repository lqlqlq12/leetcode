package _201_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//218.天际线问题
/*筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。

每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：

lefti 是第 i 座建筑物左边缘的 x 坐标。
righti 是第 i 座建筑物右边缘的 x 坐标。
heighti 是第 i 座建筑物的高度。
你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。

天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。

注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]*/
//buildings 按 lefti 非递减排序
//官解:首先关键点只会出现在矩形的左右边缘处 所以遍历每一个边缘 然后从覆盖该边缘处的全部顶选出最高的 注意刚好右边界到的不算覆盖 还有如果这条边缘的最高点和上一个边缘的最高点一样 说明这个边缘不算关键点
public class GetSkyLine {
    public List<List<Integer>> getSkyLine(int[][] buildings) {
        List<Integer> boundaries = new ArrayList<>();
        List<List<Integer>> re = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] build : buildings) {
            boundaries.add(build[0]);
            boundaries.add(build[1]);
        }
        Collections.sort(boundaries);
        int index = 0, len = buildings.length;
        for (Integer boundary : boundaries) {
            while (index < len && buildings[index][0] <= boundary) {
                pq.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }
            int height = pq.isEmpty() ? 0 : pq.peek()[1];
            if (re.isEmpty() || re.get(re.size() - 1).get(1) != height) {
                List<Integer> t = new ArrayList<>();
                t.add(boundary);
                t.add(height);
                re.add(t);
            }
        }
        return re;
    }
}
