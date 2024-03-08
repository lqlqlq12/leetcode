package _1_200;

//60.排序序列
/*给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。*/
//md 做不来 好吧 其实有点思路 但没往下想 结果思路对了
//以3为例 1开头的有2个 2开头的有2个 3开头的有2个 所以有了k就可以确定第一个元素是哪一个
//同理 就是123中 去掉第一个元素 继续选第二个元素 变成了子问题
//先建立一个数组 factorial[i] 表示i!的值
//卧槽 一遍过 nb
public class GetPermutation {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        boolean[] used = new boolean[n + 1];
        char[] re = new char[n];
        //一次确定一个数
        for (int i = 0; i < n; i++) {
            int step = factorial[n - i - 1];
            int rank = (k - 1) / step; //rank表示第几小的 从0开始
            k -= (rank * step);
            for (int j = 1, count = 0; j <= n; j++) {
                if (!used[j]) {
                    count++;
                }
                if (count > rank) {
                    used[j] = true;
                    re[i] = (char) ('0' + j);
                    break;
                }
            }
        }
        return new String(re);
    }
}
