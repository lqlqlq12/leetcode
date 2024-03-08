package leetcode75.BinarySearch;

import hot100.SpiralOrder;

//875.爱吃香蕉的珂珂
/*珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。

珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，

她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。*/
//piles.length>=h
//思路:当h=n时 那就是一小时吃掉一堆 re=max(piles[i])
//当 h=n+1时 也就是说有一堆香蕉可以分两次吃 那肯定是将最大的香蕉堆来分两次吃
//官解:二分 当k>answer时可以吃完 当k<answer时 吃不完
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int low = 1, high = 1;
        for (int i = 0; i < len; i++) {
            if (piles[i] > high) {
                high = piles[i];
            }
        }
        while (low < high) {
            int mid = (low + high) >> 1;
            int needed = 0;
            for (int i = 0; i < len; i++) {
                needed += ((piles[i] + mid - 1) / mid);
            }
            if (needed > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
