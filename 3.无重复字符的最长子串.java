import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        int i = 0;
        int maxLength = 0;
        List<Character> result = new ArrayList<>();
        result.add(s.charAt(i));
        for (int j = 1; j < s.length(); j++) {
            if (result.contains(s.charAt(j))) {
                maxLength = result.size() > maxLength ? result.size() : maxLength;
                i++;
                j = i;
                result.clear();
                result.add(s.charAt(i));
                continue;
            }
            result.add(s.charAt(j));
        }
        maxLength = result.size() > maxLength ? result.size() : maxLength;
        return maxLength;
    }
}
// @lc code=end
