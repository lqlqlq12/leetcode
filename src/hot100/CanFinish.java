package hot100;

import java.util.*;

//课程表
/*你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。*/
//拓扑排序,判断是否为有向无环图 dfs,每次选出出度为0的节点将其移除,节点的选择顺序的倒序就是拓扑排序的结果
//bfs+拓扑排序 每次选取入度为0的节点将其移除
//bfs或dfs都是)(m+n)
//快慢指针 好像不可以,因为一个节点后可以有多个节点
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edge=new ArrayList<>(); //一个节点的后继结点
        for(int i=0;i<numCourses;i++){
            edge.add(new ArrayList<>());
        }
        int[] inDu=new int[numCourses]; //每个节点的入度
        for (int[] ints : prerequisites) {
            edge.get(ints[1]).add(ints[0]);
            inDu[ints[0]]++;
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDu[i]==0){
                queue.offer(i);
            }
        }
        int visited=0;
        while(!queue.isEmpty()){
            visited++;
            Integer u = queue.poll();
            List<Integer> nexts = edge.get(u);
            for (Integer next : nexts) {
                inDu[next]--;
                if(inDu[next]==0){
                    queue.offer(next);
                }
            }
        }

        return visited==numCourses;
    }


}
