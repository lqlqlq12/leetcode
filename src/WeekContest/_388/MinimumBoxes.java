package WeekContest._388;

import java.util.Arrays;

//100233.重新分装苹果
/*给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。

一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。

请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。

注意，同一个包裹中的苹果可以分装到不同的箱子中。*/
//思路:求总共有多少个苹果 然后尽量放到大的箱子里
public class MinimumBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0, re = 0, m = capacity.length;
        for (int i : apple) {
            sum += i;
        }
        if (sum == 0) {
            return re;
        }
        Arrays.sort(capacity);
        for (int i = m - 1; i >= 0; i--) {
            sum -= capacity[i];
            re++;
            if (sum <= 0) {
                return re;
            }
        }
        return re;
    }
}
