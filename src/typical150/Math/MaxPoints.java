package typical150.Math;

import java.util.HashMap;
import java.util.Map;

//149.直线上最多的点数
/*给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。*/
//好难啊
public class MaxPoints {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2) return len;
        int re = 0;
        for (int i = 0; i < len; i++) {
            if (re * 2 > len || len - i <= re) {
                return re;
            }
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < len; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int mod = gcd(Math.abs(x), y);
                    x /= mod;
                    y /= mod;
                }
                String key = x + "-" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Integer value : map.values()) {
                re = Math.max(re, value + 1);
            }
        }
        return re;
    }

    public int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }

    public void test() {
        maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
    }

    public static void main(String[] args) {
        new MaxPoints().test();
    }

    //暴力
    public int func(int[][] points) {
        int len = points.length;
        if (len <= 2) return len;
        int re = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int cnt = 2;
                for (int k = j + 1; k < len; k++) {
                    int s1 = (points[k][1] - points[j][1]) * (points[j][0] - points[i][0]);
                    int s2 = (points[j][1] - points[i][1]) * (points[k][0] - points[j][0]);
                    if (s1 == s2) cnt++;
                }
                re = Math.max(re, cnt);
            }
        }
        return re;
    }
}
