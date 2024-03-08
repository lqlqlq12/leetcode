package typical150.BackTracking;

import java.util.ArrayList;
import java.util.List;

//17.电话号码的字母组合
/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。*/
//思路:回溯+dfs
public class LetterCombinations {
    String[] reflect;
    char[] numbers;
    List<String> re;
    char[] combination;

    public List<String> letterCombinations(String digits) {
        reflect = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        re = new ArrayList<>();
        if (digits.isEmpty()) {
            return re;
        }
        combination = new char[digits.length()];
        this.numbers = digits.toCharArray();
        dfs(0);
        return re;
    }

    public void dfs(int index) {
        if (index == numbers.length) {
            re.add(String.valueOf(combination));
            return;
        }

        String target = reflect[numbers[index] - '2'];
        for (char c : target.toCharArray()) {
            combination[index] = c;
            dfs(index + 1);
        }
    }


}
