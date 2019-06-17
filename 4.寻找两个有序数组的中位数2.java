/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int flag = (len1 + len2)%2;
        int first,second;
        if(flag == 1){
            first = (len1 + len2)/2;
            second = first;
        }else{
            //偶数是2个  （mid+mid+1）/2
            first = (len1 + len2)/2 - 1;
            second = first + 1;
        }
        int i=0,j =0;
        double result = 0.0;
        while( i< len1 && j< len2){
           if(nums1[i] >= nums2[j]){
               if(i+j == first || i +j == second){
                    result += nums2[j];
               }
               j++;
           }else{
               if(i+j == first || i +j == second){
                    result += nums1[i];
               }
               i++;
           }
        }
        while(i<len1){
            if(i+j == first || i +j == second){
                result += nums1[i];
            }
            i++;
        }
        while(j<len2){
            if(i+j == first || i +j == second){
                result += nums2[j];
            }
            j++;
        }
        return flag == 1 ? result : result /2.0;
    }
}

