package _201_400;

import com.sun.imageio.plugins.common.BogusColorSpace;

import java.util.HashMap;
import java.util.Map;

//299.猜数字游戏
/*你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：

写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：

猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。
也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。

提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。

请注意秘密数字和朋友猜测的数字都可能含有重复数字。*/
//secret和guess的长度相等
//思路:不就是HashMap
//改进 因为字符串只由[0-9]组成 所以可以用长度10的数组代替map
public class GetHint {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int x = 0, y = 0;
        Map<Character, Integer> secMap = new HashMap<>();
        Map<Character, Integer> gueMap = new HashMap<>();
        for (char c : secret.toCharArray()) {
            secMap.put(c, secMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                x++;
            }
            char c = guess.charAt(i);
            if (secMap.containsKey(c)) {
                gueMap.put(c, gueMap.getOrDefault(c, 0) + 1);
            }
        }
        for (Character c : gueMap.keySet()) {
            y += Math.min(gueMap.get(c), secMap.get(c));
        }
        return x + "A" + (y - x) + "B";
    }

    public String optimize(String secret, String guess) {
        int len = secret.length();
        int[] sec = new int[10];
        int[] gue = new int[10];
        int x = 0, y = 0;
        for (char c : secret.toCharArray()) {
            sec[c - '0']++;
        }
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) x++;
            if (sec[guess.charAt(i) - '0'] != 0) {
                gue[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            y += Math.min(sec[i], gue[i]);
        }
        return x + "A" + (y - x) + "B";
    }
}
