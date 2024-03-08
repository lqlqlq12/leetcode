package _201_400;

import java.util.ArrayList;
import java.util.List;

//241.为运算表达式设计优先级
/*给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，

计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。

生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。*/
//官解:将数字和运算符放入一个数组中 +-*依次用-1,-2,-3来表示
//针对每一个运算符 其左边可能得到的结果和右边可能得到的结果根据中间运算符 得到可能的结果
//可以用dp[l][r]={1,23,14,12,123,...}来表示数组中nums[l:r]可以得到的解的集合
//因此主要有两种方法 dfs和动规 dfs用带记忆化的搜索 可以避免重复计算 使用动规来做
//nums[i]是数字->dp[i][i]=nums[i]
public class DiffWaysToCompute {
    List<Integer> list;

    public List<Integer> diffWaysToCompute(String s) {
        list = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                list.add(num);
            } else {
                switch (s.charAt(i)) {
                    case '+':
                        list.add(-1);
                        break;
                    case '-':
                        list.add(-2);
                        break;
                    case '*':
                        list.add(-3);
                }
                i++;
            }
        }
        int len = list.size();
        List<Integer>[][] dp = new List[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < len; i += 2) {
            dp[i][i].add(list.get(i));
        }
        //i是长度
        for (int i = 3; i <= len; i += 2) {
            //j是起点
            for (int j = 0; i + j <= len; j += 2) {
                int l = j, r = j + i - 1;
                for (int k = l + 1; k < r; k += 2) {
                    List<Integer> left = dp[l][k - 1];
                    List<Integer> right = dp[k + 1][r];
                    for (Integer x : left) {
                        for (Integer y : right) {
                            switch (list.get(k)) {
                                case -1:
                                    dp[l][r].add(x + y);
                                    break;
                                case -2:
                                    dp[l][r].add(x - y);
                                    break;
                                case -3:
                                    dp[l][r].add(x * y);
                            }
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
