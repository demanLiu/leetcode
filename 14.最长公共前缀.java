
/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < strs[0].length()) {
            for (String string : strs) {
                if (string.length() < index + 1 || strs[0].charAt(index) != string.charAt(index)) {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(index++));
        }
        return result.toString();
    }
}
// @lc code=end
