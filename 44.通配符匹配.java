/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    /**
     * 跟10题的有区别，10题*可以代表前面字符出现0次，这个只能代表空字符串
     * 
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (pa[j - 1] == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        if (m == 0 || n == 0) {
            return dp[m][n];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pa[j - 1] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && match(sa[i - 1], pa[j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }

        }
        return dp[m][n];
    }

    private boolean match(char a, char b) {
        return a == b || b == '?';
    }
}
// @lc code=end
