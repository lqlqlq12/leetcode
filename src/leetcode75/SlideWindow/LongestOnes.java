package leetcode75.SlideWindow;

import javax.crypto.Cipher;

//最大连续1的个数III
/*给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。*/
//思路:记录每一个0的下标 从当前0往前 就可以反转k个 可以直接得到此位置作为结尾的最大个数 还要有当前0的个数
//官解:使用前缀和 可以得到从[0:i]的1的个数或者0的个数 这样可以得到任意一个区间中0的个数 这样遍历left,二分查找right
//我的思路就是官解的第二种方法的滑动窗口 不要用数组记录前k个0的位置 改用一个left指针
//right先尽可能右移,窗口内不超过k个0 然后计算长度 然后left右移 直至窗口内k-1个0 right再右移 重复
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length, count = 0;
        int[] zeros = new int[len];
        int re = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros[count++] = i;
            }
            if (count <= k) {
                re = Math.max(re, i + 1);
            } else {
                re = Math.max(re, i - zeros[count - k - 1]);
            }
        }
        return re;
    }

    //[1,1,1,0,0,0,1,1,1,1,0]
    //滑动窗口 优雅
    public int optimize(int[] nums, int k) {
        int len = nums.length, left = 0, right = 0, count = 0, re = 0;
        for (; right < len; right++) {
            count += (1 - nums[right]);
            while (count > k) {
                count -= (1 - nums[left]);
                left++;
            }
            re = Math.max(re, right - left + 1);
        }
        return re;
    }
}
