/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (32.88%)
 * Likes:    113
 * Dislikes: 0
 * Total Accepted:    20.1K
 * Total Submissions: 61.2K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        if(n<0){
            x = 1.0/x;
            if(n== Integer.MIN_VALUE){
                return x*myPow(x, Integer.MAX_VALUE);
            }else{
                return myPow(x, -n);
            }
        }
        double half = myPow(x, n>>1);
        if(n%2 ==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
}

