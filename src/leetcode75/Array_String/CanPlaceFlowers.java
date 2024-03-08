package leetcode75.Array_String;

//605.种花问题
/*假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，
其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。*/
//贪心:尽可能种满! 010而不是001
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;
        int count = 0;
        //长度为1
        if (len == 1) {
            return n == 1 && flowerbed[0] == 0;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count = 1;
        }
        for (int i = 1; i < len - 1 && count < n; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
                i++;
            }
        }
        if (count == n) return true;
        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            count++;
        }
        return count == n;
    }

    public void test() {
        canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
    }

    public static void main(String[] args) {
        new CanPlaceFlowers().test();
    }
}
