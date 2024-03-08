package hot100;


//盛最多水的容器
/*给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。*/
//双指针,代表可以作为边界,每次移动height小的那个,若移动大的,则后续可以得到的容量就不会大于该容量
public class MaxArea {
    public int getArea(int[] height) {
        int length=height.length;
        int l=0,r=length-1;
        int re=Integer.MIN_VALUE;
        while(l<r){
            int width=r-l;
            re=Math.max(re,width*Math.min(height[l],height[r]));
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return re;
    }
}
