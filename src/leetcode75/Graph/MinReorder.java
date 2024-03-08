package leetcode75.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//1466.重新规划路线
/*n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。

去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。

路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。

今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。

请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。

题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。*/
//思路:dfs或者bfs 用邻接矩阵
//bfs超时了 不太理解 试一下dfs
//理解了 因为每次从队列拿出来一个点 要遍历邻接矩阵来找和他相连的点 所以特别慢 不可以用邻接矩阵
//换一个 每一个点只能有两条边 所以可以把矩阵变成 2*n 正数表示去访问别人 负数表示被别人访问
//又错了 每个点不一定只有两个边 最多可以有n-1个 用list吧
public class MinReorder {

    public int minReorder(int n, int[][] connections) {
        List<Integer>[] edge = new List[n];
        boolean[] visited = new boolean[n];
        int re = 0;
        for (int[] connection : connections) {
            int start = connection[0], end = connection[1];
            if (edge[start] == null) edge[start] = new ArrayList<>();
            if (edge[end] == null) edge[end] = new ArrayList<>();
            edge[start].add(end);
            edge[end].add(-start);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int point = queue.poll();
                for (int j = 0; j < edge[point].size(); j++) {
                    int next = edge[point].get(j);
                    if (visited[Math.abs(next)]) continue;
                    if (next < 0) next = -next;
                    else re++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return re;
    }

    public void test() {
        //1,0],[1,2],[2,3],[4,2]
        // 0<-1->2->3
        //       |
        //       4
        minReorder(5, new int[][]{{1, 0}, {1, 2}, {2, 3}, {4, 2}});
    }

    public static void main(String[] args) {
        new MinReorder().test();
    }
}
