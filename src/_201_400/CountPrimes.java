package _201_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//204.计数质数
/*给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。*/
//2 3 5 7
//思路:质数一定是6的周围(除2和3)
//埃氏筛和线性筛
//埃氏筛 时间O(nloglogn) 空间O(n)
//线性筛 时间O(n) 空间O(n)
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        else if (n <= 4) return n - 2;
        int re = 2;
        for (int i = 1; i * 6 - 1 < n; i++) {
            if (isPrime(6 * i - 1)) re++;
            if (i * 6 + 1 < n && isPrime(i * 6 + 1)) re++;
        }
        return re;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //埃氏筛
    public int method_1(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int re = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                re++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return re;
    }

    //2 primes:2 arr[4]=0
    //3 primes:2 3 arr[6],arr[9]=0
    //4 primes:2 3 arr[8]=0 break 对于arr[12]在后面会被标记 不重复标记
    //5 primes:2 3 5 arr[10,15,25]=0
    //6 primes:2 3 5 arr[12]=0break
    //如果x%primes[i]==0 那么break 因为对于x*primes[i+1]这个数 它会在 遍历x/primes[i]*primes[i+1]时被标记
    public int method_2(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
