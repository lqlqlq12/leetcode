package WeekContest._390;

import org.junit.Test;

import java.util.*;

//100528.最高频率的 ID
/*你需要在一个集合里动态记录 ID 的出现频率。给你两个长度都为 n 的整数数组 nums 和 freq ，nums 中每一个元素表示一个 ID ，对应的 freq 中的元素表示这个 ID 在集合中此次操作后需要增加或者减少的数目。

增加 ID 的数目：如果 freq[i] 是正数，那么 freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会添加到集合中。
减少 ID 的数目：如果 freq[i] 是负数，那么 -freq[i] 个 ID 为 nums[i] 的元素在第 i 步操作后会从集合中删除。
请你返回一个长度为 n 的数组 ans ，其中 ans[i] 表示第 i 步操作后出现频率最高的 ID 数目 ，如果在某次操作后集合为空，那么 ans[i] 为 0 。*/
public class MostFrequentIDs {

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int len = nums.length;
        long[] re = new long[len];
        TreeMap<Long, List<Integer>> sortmap = new TreeMap<>();
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                sortmap.get(map.get(nums[i])).remove(Integer.valueOf(nums[i]));
                if(sortmap.get(map.get(nums[i])).isEmpty()){
                    sortmap.remove(map.get(nums[i]));
                }
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0L) + freq[i]);
            long fre = map.get(nums[i]);
            if (!sortmap.containsKey(fre)) {
                sortmap.put(fre, new LinkedList<>());
            }
            sortmap.get(fre).add(nums[i]);
            re[i] = sortmap.lastEntry().getKey();
        }
        return re;
    }

    @Test
    public void test() {
        for (long l : mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})) {
            System.out.println(l);
        }

    }
}
