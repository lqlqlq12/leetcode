package _201_400;

//335.路径交叉
/*给你一个整数数组 distance 。

从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。

也就是说，每次移动后你的方位会发生逆时针变化。

判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。*/
//分三类:1.上左下右 右和上交叉 2.上左下右上 两个上重叠 3.上左下右上左 第1上和第二左交叉
public class IsSelfCrossing {

    public boolean isSelfCrossing(int[] distance) {
        int len = distance.length;
        for (int i = 3; i < len; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            if (i == 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }
            if (i > 4 && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] <= distance[i - 3] && distance[i - 1] + distance[i - 5] >= distance[i - 3] && distance[i - 2] > distance[i - 4]) {
                return true;
            }
        }
        return false;
    }
}
