package typical150.BackTracking;

import java.util.ArrayList;
import java.util.List;

//22.括号生成
/*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。*/
//思路:在任意一个位置:可以选择添加'('或者')'
//添加'('的条件:'('的数量不大于n
//添加')'的条件:')'的数量小于'('的数量
public class GenerateParenthesis {
    char[] parenthesis;
    List<String> re;

    public List<String> generateParenthesis(int n) {
        parenthesis = new char[2 * n];
        re = new ArrayList<>();
        backTrack(0, 0, 0, n);
        return re;
    }

    public void backTrack(int index, int leftNumber, int rightNumber, int n) {
        if (index == 2 * n) {
            re.add(new String(parenthesis));
            return;
        }
        if (leftNumber < n) {
            parenthesis[index] = '(';
            backTrack(index + 1, leftNumber + 1, rightNumber, n);
        }
        if (rightNumber < leftNumber) {
            parenthesis[index] = ')';
            backTrack(index + 1, leftNumber, rightNumber + 1, n);
        }
    }
}
