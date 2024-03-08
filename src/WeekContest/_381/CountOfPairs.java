package WeekContest._381;

//100188. 按距离统计房屋对数目 I
/*给你三个 正整数 n 、x 和 y 。

在城市中，存在编号从 1 到 n 的房屋，由 n 条街道相连。对所有 1 <= i < n ，都存在一条街道连接编号为 i 的房屋与编号为 i + 1 的房屋。另存在一条街道连接编号为 x 的房屋与编号为 y 的房屋。

对于每个 k（1 <= k <= n），你需要找出所有满足要求的 房屋对 [house1, house2] ，即从 house1 到 house2 需要经过的 最少 街道数为 k 。

返回一个下标从 1 开始且长度为 n 的数组 result ，其中 result[k] 表示所有满足要求的房屋对的数量，即从一个房屋到另一个房屋需要经过的 最少 街道数为 k 。

注意，x 与 y 可以 相等 。*/
public class CountOfPairs {
    public int[] countOfPairs(int n, int x, int y) {
        int[] re = new int[n];
        if (x == y) {
            for (int i = 0; i < n; i++) {
                re[i] = 2 * (n - i - 1);
            }
            return re;
        }
//        re[0] = -4;
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        int mid = (x + y) >> 1;
        for (int i = 0; i < n; i++) {
            int[] lens = new int[5];
            int[] remain = new int[4];
            lens[0] = mid;
            lens[1] = x + y - mid;
            lens[2] = n - mid + 1;
            lens[3] = n - y + 1 + mid - x;
            lens[4] = x + n - y + 1;
            remain[0] = x;
            remain[1] = n - y + 1;
            remain[2] = x + 1;
            remain[3] = n - y + 2;
            for (int j = 0; j < 5; j++) {
                if (lens[j] > i) {
                    re[i] += (lens[j] - i - 1);
                }
            }
            for (int j = 0; j < 4; j++) {
                if (remain[j] > i) {
                    re[i] -= (remain[j] - i - 1);
                }
            }
            re[i] *= 2;
        }
//        re[0] -= 4;
        return re;
    }

    //1 2
    //1 3
    //1 3
    //2 3
    //1 3
    public void test() {
        countOfPairs(4, 1, 1);
    }

    public static void main(String[] args) {
        new CountOfPairs().test();
    }

}
