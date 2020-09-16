import java.util.*;


public class Solution {
    /**
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int firstMissingPositive (int[] nums) {
        // write code here
        int l =0;
        int r = nums.length;

        while(l<r){

            if(nums[l]==l+1){
                l++;
            }else if(nums[l]<=l || nums[l]>r || nums[nums[l]-1]==nums[l]) {

                nums[l]=nums[--r];
            }else {
                swap[nums,l,nums[l]-1];
            }
        }
        return l+1;
    }
}
