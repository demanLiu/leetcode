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
        int mid;
        if(flag == 1){
            mid = len1 + (len2-len1)/2;
        }else{
            //偶数是2个  （mid+mid+1）/2
            mid = len1 + (len2 - len1)/2 - 1;
        }
        int i=0,j =0;
        int index = 0;
        int result = 0;
        while(i< len1 && j<len2){
           if(nums1[i] >= nums2[j]){
               result = nums2[j];
               j++;
           }else{
               result = nums1[i];
               i++;
           }
           if(index == mid){
                if(flag == 1){
                    return result;
                }
                //get next
                return (result + Math.min(nums1[i], nums2[j]))/2.0;
           }
           index ++;
        }
        while(i<len1 && i< index){
            if(index == mid){
                if(flag == 1){
                   return nums1[i] ;
                }
                return (nums1[i] + nums1[i+1])/2.0;
            }
            index++;
        }
        while(j<len2 && j < index){
            if(index == mid){
                if(flag == 1){
                   return nums2[j] ;
                }
                return (nums2[j] + nums2[j+1])/2.0;
            }
            index++;

        }
    }
}

