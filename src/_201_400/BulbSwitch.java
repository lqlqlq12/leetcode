package _201_400;

import java.util.Arrays;

//319.灯泡开关
/*初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。

接下来的第二轮，你将会每两个灯泡关闭第二个。

第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。

第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。

找出并返回 n 轮后有多少个亮着的灯泡。*/
//先模拟做
//超时了 要找规律了
//第二轮切换了 [1 3 5 7 9 11 13 15 17...]
//第三轮切换了 [2 5 8 11 14 17 20...]
//似乎发现规律了 下标从1开始: 第二轮就是[2 4 6 8 10 12 14 16 18]
//第三轮就是[3 6 9 12 15 18...]
//也就是说 第i个灯泡1<=i<=n被切换多少次 全看1-i中有多少能被i整除 就是i%j==0
//思路 从1开始遍历 维护一个count[]数组 count[i]表示i出现了多少次
//1->count[1:n]++
//2->count[2,4,6...n]++
//3->count[3,6,9...n]++
//O(n^2) 这样和模拟一样不是 不行
//假设 能被a整除的有 (a1,a2,a3,a4...a)递增
//那么 能被2*a整除的有 (a1,a2,a3,...a)+(2a1,2a2,2a3...2a)
//那么 能被2*a+1整除的有
//好吧 看了官解 如果i在[1-i]中有x个数能被他整除 如果i/num=a 则num,a都在[1-i] 如果num!=a 则i就每次增加两个约数
//那么 出现奇数个约数的就是 num=a的数 也就是 完全平方
public class BulbSwitch {
    public int bulbSwitch(int n) {
        int[] bulbs = new int[n];
        Arrays.fill(bulbs, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                bulbs[j - 1] = 1 - bulbs[j - 1];
            }
        }
        int re = 0;
        for (int i = 0; i < n; i++) {
            if (bulbs[i] != 0) re++;
        }
        return re;
    }

    public int optimize(int n) {
        int re = 0;
        for (int i = 1; i * i <= n; i++, re++) ;
        return re;

    }
}
