import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 *
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * algorithms
 * Medium (44.85%)
 * Likes:    333
 * Dislikes: 0
 * Total Accepted:    20.3K
 * Total Submissions: 45.3K
 * Testcase Example:  '[4,3,2,3,5,2,1]\n4'
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 
 * 示例 1：
 * 
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = sum / k;
        if (sum % k != 0 || nums[nums.length - 1] > target) {
            return false;
        }
        return helpler(new int[k], nums, 0, target);

    }

    private boolean helpler(int[] groups, int[] nums, int curIndex, int target) {
        if (curIndex >= nums.length) {
            return true;
        }
        int val = nums[curIndex++];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + val <= target) {
                groups[i] += val;
                if (helpler(groups, nums, curIndex, target)) {
                    return true;
                }
                groups[i] -= val;
            }
            if (groups[i] == 0)
                break;

        }
        return false;
    }

}
// @lc code=end
