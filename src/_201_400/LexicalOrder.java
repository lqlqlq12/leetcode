package _201_400;

import java.util.ArrayList;
import java.util.List;

//386.字典序排数
/*给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。

你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。*/
//思路:dfs
public class LexicalOrder {

    List<Integer> re;

    public List<Integer> lexicalOrder(int n) {
        re = new ArrayList<>();
        for (int i = 1; i < 10 && i <= n; i++) {
            dfs(n, i);
        }
        return re;
    }

    public void dfs(int n, int num) {
        re.add(num);
        num *= 10;
        for (int i = 0; i < 10 && num + i <= n; i++) {
            dfs(n, num + i);
        }
    }
}
