/*
 * @lc app=leetcode.cn id=795 lang=java
 *
 * [795] 区间子数组个数
 *
 * https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/description/
 *
 * algorithms
 * Medium (53.00%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    6.2K
 * Total Submissions: 11.7K
 * Testcase Example:  '[2,1,4,3]\n2\n3'
 *
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * 
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * 
 * 例如 :
 * 输入: 
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 
 * 
 * 注意:
 * 
 * 
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return helper(A, R) - helper(A, L - 1);
    }

    private int helper(int[] A, int L) {
        int cur = 0, count = 0;
        for (int i : A) {
            cur = i <= L ? cur + 1 : 0;
            count += cur;
        }
        return count;
    }

}
// @lc code=end
