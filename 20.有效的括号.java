import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (38.49%)
 * Likes:    857
 * Dislikes: 0
 * Total Accepted:    84K
 * Total Submissions: 218.1K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Solution {
    public boolean isValid(String s) {
        if(s==""){
            return  true;
        }
        Stack<Character> stack = new Stack<Character>();
        int len  = s.length();
        for(int i=0;i<len;i++){
            if(stack.isEmpty() || s.charAt(i) == '(' ||
            s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                char p = stack.pop();
                if(s.charAt(i) == ')' && p != '('){
                    return false;
                }
                if(s.charAt(i) == '}' && p != '{'){
                    return false;
                }
                if(s.charAt(i) == ']' && p != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

