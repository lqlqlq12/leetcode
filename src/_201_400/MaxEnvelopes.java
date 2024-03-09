package _201_400;

import org.junit.Test;

import java.util.*;

//354.俄罗斯套娃信封问题
/*给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。

当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

注意：不允许旋转信封。*/
//思路:肯定先排序 然后动规 O(n^2) dp[i]=dp[j]+1 可以使用二分找到这个j 这个j肯定是符合条件并且尽量大的 用二分
//符合条件的肯定宽度都小于envelopes[i][0] 在宽度小于的情况下 就要高度尽可能高
//看了官解:有一个技巧 对宽度递增排序再对高度递减排序 这样就不用考虑宽度一样 但高度不同的情况了 因为同宽度的先计算高的
//不会被矮的影响 矮的也无法包住高的
//官解就是要找到一个尽可能长的递增序列 那就是借鉴最长递增子序列 和 递增三元子序列了的做法了
//f[j]表示长度为j的自增序列的最后一个元素所能取得到的最小值 遍历过程更新f[j] 能跟在后面长度加1 跟不住更信f[] 用二分更新
public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                int t = o1[0] - o2[0];
                if (t != 0) return t;
                return o2[1] - o1[1];
            }
        });
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        for (int i = 1; i < len; i++) {
            if (envelopes[i][1] > list.get(list.size() - 1)) {
                list.add(envelopes[i][1]);
            } else {
                binarySearch(list, envelopes[i][1]);
            }
        }
        return list.size();
    }

    //num<=list(end)
    //找到index 有list(index)>=num 并且index尽可能小
    public void binarySearch(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        list.set(left, num);
    }


}
