package typical150.Graph;

import java.util.*;

//课程表II
/*现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。

例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。
如果不可能完成所有课程，返回 一个空数组 。*/
public class FindOrder {
    int[] re;
    int[] inDu;
    Map<Integer, List<Integer>> after;
    Queue<Integer> queue;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        re = new int[numCourses];
        int completed = 0;
        inDu = new int[numCourses];
        after = new HashMap<>();
        queue = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDu[prerequisites[i][0]]++;
            List<Integer> t = after.getOrDefault(prerequisites[i][1], new ArrayList<>());
            t.add(prerequisites[i][0]);
            after.put(prerequisites[i][1], t);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDu[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            re[completed++] = course;
            List<Integer> list = after.get(course);
            if (list != null) {
                for (Integer af : list) {
                    inDu[af]--;
                    if (inDu[af] == 0) {
                        queue.offer(af);
                    }
                }
            }
        }
        return completed != numCourses ? new int[0] : re;
    }
}
