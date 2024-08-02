package Leetcode_Daily_Challenge;

// Leetcode:- https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
//Question :- 2134. Minimum Swaps to Group All 1's Together II
//Date :- 02/08/2024
public class MinSwapToGrpAll_1s {
    public int minSwaps(int[] nums) {

        int current=0;
        int ws=0;
        for(int num:nums){
            if(num==1){
                ws++;
            }
        }
        for(int i=0;i<ws;i++){
            if(nums[i]==0){
                current++;
            }
        }
        int minzero=current;
        int start=0;
        int end=ws-1;
        int n=nums.length;
        while(start<n){
            if(nums[start]==0){
                current--;
            }
            start++;
            end++;
            if(nums[end%n]==0){
                current++;
            }
            minzero=Math.min(minzero,current);
        }
        return minzero;
    }
}
