class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = nums[0];
        int n = -1;
        for(int i = 1;i<nums.length;i++){
           if(nums[i] > minVal){
            n = Math.max(n, nums[i] - minVal);
           }else{
            minVal = nums[i];
           }
        }
        return n;
    }
}