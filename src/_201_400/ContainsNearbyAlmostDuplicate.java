package _201_400;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

//220.存在重复元素III
/*给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。

找出满足下述条件的下标对 (i, j)：

i != j,
abs(i - j) <= indexDiff
abs(nums[i] - nums[j]) <= valueDiff
如果存在，返回 true ；否则，返回 false 。*/
//思路:用一个滑动窗口 要添加的元素是否和窗口内的元素距离够近 直接遍历窗口超时 需要用有序集合
//如果集合里已经有了就是距离为0 直接找到了
//set.ceiling(E e) 返回集合中最小的且大于等于所给数字的元素
//{nums[i]-valueDiff,nums[i]+valueDiff}
//所以找出最小的且大于等于nums[i]-valueDiff的值 判断它是否小于等于nums[i]+valueDiff即可
//注意一下可能会超过Integer的范围
//桶排序:假设valueDiff为3 那桶的大小就为3 用一个Map来保存桶<桶id,nums[i]>
//可以保证桶里至多只有一个元素 可以根据nums[i]和valueDiff来获取桶id
//如果要将一个元素放入桶时发现桶里已经有其他元素了 那这两个元素距离肯定<=valueDiff 接返回true
//放进桶后 和相邻的两个桶比较一下 如果距离<=valueDiff 也返回true
//遍历了 indexDiff+1后 移除最前面的就好
//桶排序O(n) 有序集合O(nlog(min(n,k)))
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int len = nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Integer ceiling = set.ceiling(nums[i] - valueDiff);
            if (ceiling != null && ceiling <= nums[i] + valueDiff) {
                return true;
            }
            set.add(nums[i]);
            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }

    //size=1 0,1 2,3 -1,-2 -3,-4
    //size=2 0,1,2 -1,-2,-3 3,4,5
    public boolean bucketSort(int[] nums, int indexDiff, int valueDiff) {
        valueDiff++;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            int id = 0;
            if (nums[i] >= 0) id = nums[i] / valueDiff;
            else {
                id = (nums[i] + 1) / valueDiff - 1;
            }
            if (map.containsKey(id)) return true;
            else if (map.containsKey(id - 1) && nums[i] - map.get(id - 1) < valueDiff) return true;
            else if (map.containsKey(id + 1) && map.get(id + 1) - nums[i] < valueDiff) return true;
            map.put(id, nums[i]);
            if (i >= indexDiff) {
                int t = 0;
                if (nums[i - indexDiff] >= 0) t = nums[i - indexDiff] / valueDiff;
                else {
                    t = (nums[i - indexDiff] + 1) / valueDiff - 1;
                }
                map.remove(t);
            }
        }
        return false;
    }

    public void test() {
        bucketSort(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }

    public static void main(String[] args) {
        new ContainsNearbyAlmostDuplicate().test();
    }
}
