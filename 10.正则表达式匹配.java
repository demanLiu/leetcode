/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        dp[0][0] = true;
        // s "" p=.*
        for (int j = 1; j < n; j++) {
            if (pArr[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (pArr[j - 1] != '*') {
                    if (match(sArr[i - 1], pArr[j - 1])) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (match(sArr[i - 1], pArr[j - 2])) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }

            }
        }
        return dp[m - 1][n - 1];

    }

    private boolean match(char s, char p) {
        return s == p || p == '.';
    }

}
// @lc code=end
