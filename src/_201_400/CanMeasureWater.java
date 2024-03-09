package _201_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//365.水壶问题
/*有两个水壶，容量分别为 x 和 y 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 target 升。

你可以：

装满任意一个水壶
清空任意一个水壶
将水从一个水壶倒入另一个水壶，直到接水壶已满，或倒水壶已空。*/
//一看到就像用动规 状态转移 一共有六种可以选择的操作
//用a,b表示两个水壶目前的水
//装满x 则a=x
//装满y 则b=y
//清空x 则a=0
//清空y 则b=0
//将x倒入y 则b+=a a=0 或者a-=y-b b=y
//将y倒入x则反之
//然后用动规 dp[i][6][2] 分别表示通过6种操作后 x和y分别剩多少水 当出现循环的时候就说明不可能
//感觉不是最优解
//用动规代码优点麻烦 用dfs吧 用一个Map<Integer,Set<Integer>> 来记录之前出现的
//额 超过了 58% 看来是最优解了 官解也没有什么骚操作了
//官解确实有骚操作 又是数学
//首先 贝祖定理 a*x+b*y=z有解时 当且仅当z是x和y的最大公约数的倍数
//接着 可以证明 两个桶 一定有一个空 或者一定有一个满 并且每次都只能使总量+-x或者+-y
//将半满的桶装满或排空 都是回到初始状态 没有意义 所以增量都是+-x+-y
//woc太6了
public class CanMeasureWater {
    Map<Integer, Set<Integer>> map;
    int target, x, y;

    public boolean canMeasureWater(int x, int y, int target) {
        this.target = target;
        this.x = x;
        this.y = y;
        if (target == 0 || target == x || target == y || target == x + y) return true;
        map = new HashMap<>();
        return dfs(0, 0);
    }

    public boolean dfs(int a, int b) {
        if (map.containsKey(a) && map.get(a).contains(b)) return false;
        if (!map.containsKey(a)) map.put(a, new HashSet<>());
        map.get(a).add(b);
        if (a + b == target) return true;
        if (dfs(0, b)) return true;
        if (dfs(a, 0)) return true;
        if (dfs(x, b)) return true;
        if (dfs(a, y)) return true;
        if (a + b > y) {
            if (dfs(a - (y - b), y)) return true;
        } else {
            if (dfs(0, a + b)) return true;
        }
        if (a + b > x) {
            if (dfs(x, b - (x - a))) return true;
        } else {
            if (dfs(a + b, 0)) return true;
        }
        return false;
    }

    public int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    public boolean optimize(int x, int y, int target) {
        if (x + y < target) return false;
        if (x == 0 || y == 0) {
            return target == 0 || x + y == target;
        }
        return target % gcd(x, y) == 0;
    }
}
