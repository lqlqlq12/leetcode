package _401_600;

import java.util.ArrayList;
import java.util.List;

//401.二进制手表
//重拳出击
//遍历hour亮的led数量
public class ReadBinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> re = new ArrayList<>();
        for (int i = 0; i <= turnedOn && i <= 4; i++) {
            if (turnedOn - i > 6) continue;
            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();
            dfs(0, 4, i, 0, hours, 11);
            dfs(0, 6, turnedOn - i, 0, minutes, 59);
            for (Integer hour : hours) {
                for (Integer minute : minutes) {
                    if (minute >= 10) {
                        re.add(hour + ":" + minute);
                    } else {
                        re.add(hour + ":0" + minute);
                    }
                }
            }
        }
        return re;
    }


    public void dfs(int index, int len, int target, int number, List<Integer> list, int ceil) {
        if (number > ceil) {
            return;
        }
        if (target == 0) {
            list.add(number);
            return;
        }

        for (int i = index; i < len; i++) {
            dfs(i + 1, len, target - 1, number + (1 << i), list, ceil);
        }
    }
}
