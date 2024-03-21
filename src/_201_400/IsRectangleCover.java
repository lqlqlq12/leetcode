package _201_400;

import org.junit.Test;

import java.util.*;

//391.完美矩形
/*给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。

如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。*/
//初步思路:使用bfs 先对矩形排序 从最左下角的开始 往右上角遍历
//每次根据左下角选择放入哪些矩形 放入一个矩形后 接下来要放进去的就是它的左上和右下了
//写了半死的bfs才击败5%
//官解:用一个Map存矩形的顶点 顶点会有重合的
public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int low = rectangles[0][1], left = rectangles[0][0], height = 0, right = 0;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
            height = Math.max(height, rectangles[i][3]);
            low = Math.min(low, rectangles[i][1]);
            right = Math.max(right, rectangles[i][2]);
        }
        if (totalSum != (height - low) * (right - left)) return false;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{rectangles[0][0], rectangles[0][1], rectangles[0][2], rectangles[0][3]});
        int count = 1;
        boolean[] used = new boolean[n];
        used[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                boolean t1 = false, t2 = false;
                if (poll[2] == right) {
                    t2 = true;
                }
                if (poll[3] == height) {
                    t1 = true;
                }
                for (int j = 0; j < n && (!t1 || !t2); j++) {
                    if (!t1) {
                        if (rectangles[j][1] == poll[3]) {
                            if (rectangles[j][0] > poll[0] || rectangles[j][2] <= poll[0]) {
                                continue;
                            }
                            t1 = true;
                            if (rectangles[j][0] == poll[0] && !used[j]) {
                                used[j] = true;
                                count++;
                                queue.offer(rectangles[j]);
                            }
                            continue;
                        }
                    }
                    if (!t2) {
                        if (rectangles[j][0] == poll[2]) {
                            if (rectangles[j][3] <= poll[1] || rectangles[j][1] > poll[1]) {
                                continue;
                            }
                            t2 = true;
                            if (rectangles[j][1] == poll[1] && !used[j]) {
                                queue.offer(rectangles[j]);
                                used[j] = true;
                                count++;
                            }
                        }
                    }

                }
                if (!t1 || !t2) {
                    return false;
                }
            }
        }
        return count == n;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return x * 123 + y;
        }
    }

    public boolean optimize(int[][] rectangle) {
        int n = rectangle.length;
        int left = rectangle[0][0], right = rectangle[0][2], top = rectangle[0][3], bottom = rectangle[0][1];
        int sum = 0;
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < rectangle.length; i++) {
            Point p1 = new Point(rectangle[i][0], rectangle[i][1]);
            Point p2 = new Point(rectangle[i][0], rectangle[i][3]);
            Point p3 = new Point(rectangle[i][2], rectangle[i][1]);
            Point p4 = new Point(rectangle[i][2], rectangle[i][3]);
            map.put(p1, map.getOrDefault(p1, 0) + 1);
            map.put(p2, map.getOrDefault(p2, 0) + 1);
            map.put(p3, map.getOrDefault(p3, 0) + 1);
            map.put(p4, map.getOrDefault(p4, 0) + 1);
            sum += (rectangle[i][2] - rectangle[i][0]) * (rectangle[i][3] - rectangle[i][1]);
            left = Math.min(left, rectangle[i][0]);
            right = Math.max(right, rectangle[i][2]);
            top = Math.max(top, rectangle[i][3]);
            bottom = Math.min(bottom, rectangle[i][1]);
        }
        if (sum != (top - bottom) * (right - left)) return false;
        if (map.getOrDefault(new Point(left, bottom), 0) != 1 ||
                map.getOrDefault(new Point(left, top), 0) != 1 ||
                map.getOrDefault(new Point(right, bottom), 0) != 1 ||
                map.getOrDefault(new Point(right, top), 0) != 1) {
            return false;
        }
        map.remove(new Point(left, bottom));
        map.remove(new Point(left, top));
        map.remove(new Point(right, bottom));
        map.remove(new Point(right, top));
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    //11^11 11^(10^01) 11^(10^(01^00))

    @Test
    public void test() {
        isRectangleCover(new int[][]{{0, 0, 4, 1}, {7, 0, 8, 2}, {6, 2, 8, 3}, {5, 1, 6, 3}, {4, 0, 5, 1}, {6, 0, 7, 2}, {4, 2, 5, 3}, {2, 1, 4, 3}, {0, 1, 2, 2}, {0, 2, 2, 3}, {4, 1, 5, 2}, {5, 0, 6, 1}});
    }
}
