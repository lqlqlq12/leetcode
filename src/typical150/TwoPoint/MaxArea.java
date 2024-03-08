package typical150.TwoPoint;

//11.盛水最多的容器
/*给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器*/
//思路 双指针 left=0 and right=n-1 如果height[left]<height[right] 此时 area=height[left]*distance
//倘若right-- 则后续的面积area'=Math.min(height[left],height[right'])*distance',只会<=area
//所以 此时不能right-- 反而left++才有可能得到更大的面积
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                ans = Math.max(ans, (right - left) * height[left]);
                left++;
            } else {
                ans = Math.max(ans, (right - left) * height[right]);
                right--;
            }
        }
        return ans;
    }
}
