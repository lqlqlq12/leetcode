package _201_400;

//292.Nim游戏
/*你和你的朋友，两个人一起玩 Nim 游戏：

桌子上有一堆石头。
你们轮流进行自己的回合， 你作为先手 。
每一回合，轮到的人拿掉 1 - 3 块石头。
拿掉最后一块石头的人就是获胜者。
假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。
如果可以赢，返回 true；否则，返回 false 。*/
//思路:动规dp[1]=dp[2]=dp[3]=true
//dp[4]=false
//dp[5]=true 先拿一个 dp[4]是false 所以可以想办法让对面剩4个
//dp[6]=true 拿两个 然后对面剩dp[4]
//dp[7]=true 拿三个 然后对面剩dp[4]
//dp[8]=false 不管拿几个 对面都剩 dp[7,6,5]都是true 所以dp[8]=false
//dp[9,10,11]=true dp[12]=false
//所以dp[n%4==0]false else true
public class CanWinNim {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
