package typical150.HashMap;

//快乐数
/*编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。*/
//999的下一个是243,证明不会无限增大,要么变成1,要么循环,有了循环就说明会有重复,也说明有环可以用快慢指针
public class IsHappy {
    public boolean isHappy(int n){
        int fast=n,slow=n;
        do{
            fast=nextNumber(nextNumber(fast));
            slow=nextNumber(slow);
        }while (slow!=fast);
        return fast==1;
    }

    public int nextNumber(int n){
        int re=0;
        while(n>0){
            re+= (int) Math.pow((n%10),2);
            n/=10;
        }
        return re;
    }
}
