/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() ==0 ){
            return 0;
        }
        int len = str.length();
        int negative = 0;
        int i = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            negative = str.charAt(0)=='-'? 1:0;
            i++;
        }else if('0'<str.charAt(0) && str.charAt(0)>'9'){
            return 0;
        }
        int result = 0;
        for(;i<len&&str.charAt(i)>='0' && str.charAt(i) <='9';i++){
            if(result > (Integer.MAX_VALUE-(str.charAt(i)-'0'))/10){
                if(negative == 1){
                    result = Integer.MIN_VALUE;
                }else{
                    result = Integer.MAX_VALUE;
                }
                break;
            }
            result = (str.charAt(i)-'0') + 10*result;
        }
        if(negative == 1){
            result = 0 - result;
        }
        return result;
    }
}
