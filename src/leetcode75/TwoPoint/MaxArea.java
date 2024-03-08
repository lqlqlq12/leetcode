package leetcode75.TwoPoint;

//11.盛水最多的容器
/*给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。*/
//思路:双指针:
public class MaxArea {
    public int maxArea(int[] height) {
        int len = height.length;
        int re = 0;
        int left = 0, right = len - 1;
        while (left < right) {
            int lh = height[left], rh = height[right];
            if (lh <= rh) {
                re = Math.max(re, lh * (right - left));
                left++;
            } else {
                re = Math.max(re, rh * (right - left));
                right--;
            }
        }
        return re;
    }
}
