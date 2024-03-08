package typical150.Array_String;

//42.接雨水
/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。*/
//重量级 虽然做过一遍 但是自己想还是想不出来
//方法一:确认每个坐标的左右最高点 O(n^2)
//方法二:两次遍历 从左到右遍历的得到每个点的左边最高点 从右到左反之
//方法三:单调栈 栈内维护的是一个递减的数 当遍历到一个大于栈顶的柱子 这样就栈顶和栈顶下一个柱子就可以装水了
//思路:双指针 left right 左右向中靠拢 记录左边的最高和右变的最高 leftMax rightMax
//如果height[left]<height[right]那么leftMax<rightMax,left++
public class Trap {
    //双指针做法
    public int trap(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1, leftMax = 0, rightMax = 0;
        int re = 0;
        //要不要等于都一样 因为left和right都是在向最高点靠近
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
