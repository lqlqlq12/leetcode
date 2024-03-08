package _201_400;

import java.util.ArrayList;
import java.util.List;

//282.给表达式添加运算符
/*给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回 所有 能够得到 target 的表达式。

注意，返回表达式中的操作数 不应该 包含前导零。*/
//思路:动规 dp[i]表示num[0:i]能够得到的值list
//dp[i+1]=dp[i](+-*)number(num[i+1,i+1])
//dp[i+2]=dp[i](+-*)number(num[i+1,i+2])/dp[i+1](+-*)number(num[i+2,i+2])
//思路 好像不可以用动规 因为对于*号不成立
//官解:回溯 dfs O(4^n) 真tm难
public class AddOperators {
    List<String> re;
    String num;
    int target;

    public List<String> addOperators(String num, int target) {
        re = new ArrayList<>();
        this.num = num;
        this.target = target;
        dfs(0, 0, 0, new StringBuilder());
        return re;
    }

    public void dfs(int index, long prev, long cur, StringBuilder sb) {
        if (index == num.length()) {
            if (cur == target) {
                re.add(sb.toString());
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long number = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                dfs(i + 1, number, number, new StringBuilder().append(number));
            } else {
                dfs(i + 1, number, number + cur, new StringBuilder(sb).append('+').append(number));
                dfs(i + 1, -number, cur - number, new StringBuilder(sb).append('-').append(number));
                dfs(i + 1, number * prev, cur - prev + number * prev, new StringBuilder(sb).append('*').append(number));
            }
        }
    }

    public static void main(String[] args) {
        new AddOperators().addOperators("123", 6);
    }
}
