class Solution {
public:
    int maxAdjacentDistance(vector<int>& nums) {
        int a;
        for(int i = 0;i<nums.size();i++){
            if(abs(nums[i] - nums[i + 1]) > abs(nums[i + 1] - nums[i-2]){
                a = nums[i] - nums[i+1];
            }
        }
        return a;
    }
};