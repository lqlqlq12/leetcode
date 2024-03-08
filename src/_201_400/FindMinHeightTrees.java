package _201_400;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.junit.Test;

import java.util.*;

//310.最小高度树
/*树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。

给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），

其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。

可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。

在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。

请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。

树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。*/
//思路:bfs每个都来一次 直接bfs或者dfs直接超时了O(n^2)
//官解:答案一定是图中距离最远的两个点的连接路径的中点
//如何找到距离最远的两个点 首先从0出发 找到距离0最远的x 然后再从x出发找到最远的y 并且记录x到y的路径 然后返回路径的中间
public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> re = new ArrayList<>();
        List<Integer>[] sides = new List[n];
        for (int i = 0; i < n; i++) sides[i] = new ArrayList<>();
        for (int[] edge : edges) {
            sides[edge[0]].add(edge[1]);
            sides[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        queue.offer(0);
        parent[0] = 0;
        int last = 0, x = 0, y = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pre = queue.poll();
                last = pre;
                List<Integer> neList = sides[pre];
                for (int j = 0; j < neList.size(); j++) {
                    int ne = neList.get(j);
                    if (parent[ne] == -1) {
                        parent[ne] = pre;
                        queue.offer(ne);
                    }
                }
            }
        }
        x = last;
        Arrays.fill(parent, -1);
        queue.offer(x);
        parent[x] = x;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int pre = queue.poll();
                last = pre;
                List<Integer> neList = sides[pre];
                for (int j = 0; j < neList.size(); j++) {
                    int ne = neList.get(j);
                    if (parent[ne] == -1) {
                        parent[ne] = pre;
                        queue.offer(ne);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (last != x) {
            list.add(last);
            last = parent[last];
        }
        list.add(x);
        if (list.size() % 2 == 0) {
            re.add(list.get(list.size() / 2 - 1));
            re.add(list.get(list.size() / 2));
        } else {
            re.add(list.get(list.size() / 2));
        }
        return re;
    }


    @Test
    public void test() {
        findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }
}
