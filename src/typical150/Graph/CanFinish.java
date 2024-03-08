package typical150.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//207.课程表
/*你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。*/
//拓扑 每次都将入度为0的课程学了
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        for (int[] ints : prerequisites) {
            edge.get(ints[1]).add(ints[0]);
            in[ints[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> after = edge.get(curr);
            for (int i = 0; i < after.size(); i++) {
                int course = after.get(i);
                in[course]--;
                if (in[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0)
                return false;
        }
        return true;
    }
}
