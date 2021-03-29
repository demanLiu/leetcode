import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        return resultUseDp(s);
    }

    public int resultUseStack(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int maxLen = 0;
        stack.push(-1);
        char[] sArr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (sArr[i] == '(') {
                stack.push(i);
                continue;
            }
            stack.pop();
            if (!stack.isEmpty()) {
                maxLen = Math.max(i - stack.peek(), maxLen);
            } else {
                stack.push(i);
            }
        }
        return maxLen;

    }

    public int resultUseDp(String s) {
        int len = s.length();
        if (len <= 1) {
            return 0;
        }
        int[] dp = new int[len];
        char[] sArr = s.toCharArray();
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (sArr[i] == ')') {
                if (sArr[i - 1] == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && sArr[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
// @lc code=end
