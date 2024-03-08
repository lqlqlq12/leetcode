package _1_200;

import java.util.ArrayList;
import java.util.List;

//89.格雷编码
/*n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
第一个整数是 0
一个整数在序列中出现 不超过一次
每对 相邻 整数的二进制表示 恰好一位不同 ，
且第一个 和 最后一个 整数的二进制表示 恰好一位不同
给你一个整数 n ，返回任一有效的 n 位格雷码序列 。*/
//思路:没啥好想法
//官解:Gn是n的格雷编码 所以范围是[0,2^(n-1))
//将Gn倒序 然后每个元素的第n个二进制位变成1 得到Gn' Gn'的范围是[2^n,2^(n-1))
//然后Gn+1=Gn+Gn' Gn的最后一个和Gn'的第一个只有n+1为不同 Gn的第一个和Gn'的最后一个也只有n+1个不同
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> re = new ArrayList<>();
        int[] arr = new int[1 << n];
        for (int i = 1; i <= n; i++) {
            int pre = 1 << (i - 1);
            for (int j = 1; j <= pre; j++) {
                arr[pre + j - 1] = arr[pre - j] + pre;
            }
        }
        for (int i : arr) {
            re.add(i);
        }
        return re;
    }

    public void test() {
        grayCode(2);
    }

    public static void main(String[] args) {
        new GrayCode().test();
    }
}
