/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s == null){
            return "";
        }
        int len = s.length();
        int left = 0, right = 0;
        for(int i=0; i< len-1;i++){
           int len1 = helper(s, i, i);
           int len2 = helper(s, i, i+1);
           int len3 = Math.max(len1,len2);
           if(len3 > right - left){
             left = i - (len3-1)/2;
             right = i + len3/2;
           }
        }
        return s.substring(left,right +1);
    }
    public int helper(String s,int i,int j){
        while(i>=0 && j< s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return  j-i - 1;
    }
}

