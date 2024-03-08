package typical150.Stack;

import java.util.Deque;
import java.util.LinkedList;

//20.有效的括号
/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。*/
//s 仅由括号 '()[]{}' 组成
public class IsValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if (len % 2 != 0) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                stack.push(charArray[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop == '(' && charArray[i] != ')') {
                    return false;
                }
                if (pop == '[' && charArray[i] != ']') {
                    return false;
                }
                if (pop == '{' && charArray[i] != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
