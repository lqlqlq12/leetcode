package hot100;

//接雨水
/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。*/
//动规 获取每一个位置的左边和右边的最高柱子,就可以得到此柱子能接的水的量
//单调栈 每太看懂
//双指针
public class Trap {
    //动规
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int re=0;
        int lM = height[0], rM = height[len - 1];
        for (int i = 0; i < len; i++) {
            leftMax[i] = lM;
            lM = Math.max(lM, height[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            rightMax[i] = rM;
            rM = Math.max(rM, height[i]);
        }
        for(int i=0;i<len;i++){
            int t=Math.min(leftMax[i],rightMax[i]);
            re+=(t>height[i]?t-height[i]:0);
        }
        return re;
    }


    //双指针
    public int twoPoint(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = height[left], rightMax = height[right];
        int re = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                re += (leftMax - height[left]);
                left++;
            } else {
                re += (rightMax - height[right]);
                right--;
            }
        }
        return re;
    }
}
