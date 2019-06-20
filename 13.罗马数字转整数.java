
/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */
class Solution {
    public int romanToInt(String s) {
       if(s == null ||s.length() ==0){
            return 0;
       }
       int len  = s.length();
       Map<Character,Integer> map1 = new HashMap<Character,Integer>();
       map1.put('I', 1);
       map1.put('V', 5);
       map1.put('X', 10);
       map1.put('L', 50);
       map1.put('C', 100);
       map1.put('D', 500);
       map1.put('M', 1000);
       int result = 0;
       for(int i=0;i<len-1;i++){
            if(map1.get(s.charAt(i)) >= map1.get(s.charAt(i+1)) ){
                result += map1.get(s.charAt(i));
            }else{
                result -= map1.get(s.charAt(i));
            }
       }
       return result+map1.get(s.charAt(len-1));
    }
}

