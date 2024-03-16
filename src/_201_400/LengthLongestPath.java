package _201_400;

import java.util.Deque;
import java.util.LinkedList;

//388.文件的最长绝对路径
/**/
public class LengthLongestPath {

    public int lengthLongestPath(String input) {
        int len = input.length(), re = 0, index = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (index < len) {
            int depth = 1;
            while (index < len && input.charAt(index) == '\t') {
                depth++;
                index++;
            }
            int n = 0;
            boolean isFile = false;
            while (index < len && input.charAt(index) != '\n') {
                if (input.charAt(index) == '.') {
                    isFile = true;
                }
                n++;
                index++;
            }
            index++;
            while (depth <= stack.size()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                n += stack.peek() + 1;
            }
            if (isFile) {
                re = Math.max(re, n);
            } else {
                stack.push(n);
            }
        }
        return re;
    }

}
