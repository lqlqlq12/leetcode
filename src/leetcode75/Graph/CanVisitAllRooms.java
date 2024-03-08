package leetcode75.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//841.钥匙和房间
/*有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。

当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。

给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。*/
//思路:图的遍历 dfs和bfs直接干 水题
public class CanVisitAllRooms {
    //bfs
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), entered = 1;
        if (n == 1) {
            return true;
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(rooms.get(0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int room = queue.poll();
                if (!visited[room]) {
                    visited[room] = true;
                    entered++;
                    List<Integer> keys = rooms.get(room);
                    for (Integer key : keys) {
                        if (!visited[key]) {
                            queue.add(key);
                        }
                    }
                }
            }
        }
        return entered == n;
    }

    int num;

    public boolean func2(List<List<Integer>> rooms) {
        num = 1;
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(rooms.get(0), visited, rooms);
        return num == n;
    }

    //dfs
    public void dfs(List<Integer> keys, boolean[] visited, List<List<Integer>> rooms) {
        for (Integer key : keys) {
            if (!visited[key]) {
                visited[key] = true;
                num++;
                dfs(rooms.get(key), visited, rooms);
            }
        }
    }
}
