package leetcode75.TwoPoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1679.K和数对的最大数目
/*给你一个整数数组 nums 和一个整数 k 。

每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。

返回你可以对数组执行的最大操作数。*/
//思路:用hashmap,key是元素,value是出现次数 对于x,找k-x O(n)
//方法二:排序 然后双指针 O(nlogn+n)
public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length, re = 0;
        for (int i = 0; i < len; i++) {
            if (map.getOrDefault(k - nums[i], 0) != 0) {
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
                re++;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return re;
    }

    public int towPoint(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, ans = 0;
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];
            if (leftVal + rightVal == k) {
                ans++;
                left++;
                right--;
            } else if (leftVal + rightVal < k) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int t = nums[left], l = left, r = right;
            for (int i = left + 1; i <= r; ) {
                if (nums[i] < t) {
                    nums[l] = nums[i];
                    i++;
                    l++;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[r];
                    nums[r] = temp;
                    r--;
                }
            }
            nums[l] = t;
            quickSort(nums, left, l - 1);
            quickSort(nums, l + 1, right);
        }

    }

    public static void main(String[] args) {
        new MaxOperations().towPoint(new int[]{3, 1, 3, 4, 3}, 6);
    }

}
