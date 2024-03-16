package _201_400;

//390.消除游戏
/*列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：

从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
给你整数 n ，返回 arr 最后剩下的数字。*/
//n是偶数 1 2 3 4 5 6 7 8
//-> 2 4 6 8 ->2 6 ->6
//先模拟
//每次扣除一半的数字 若是偶数 则扣除n/2 若是奇数 则扣除(n/2)+1
//动规dp[i][2] dp[i][0]表示从左往右去除能得到的结果
//递归
//2 4 6 8
//4 8
//4
public class LastRemaining {
    public int lastRemaining(int n) {
        return getIndex(n, 1);
    }

    public int getIndex(int n, int direction) {
        if (n == 1) return 1;
        if (n == 2) {
            return direction == 1 ? 2 : 1;
        }
        if (direction == -1) {
            return n - 2 * (n / 2 - getIndex(n / 2, -direction) + 1) + 1;
        } else {
            return 2 * getIndex(n / 2, -direction);
        }
    }
}
