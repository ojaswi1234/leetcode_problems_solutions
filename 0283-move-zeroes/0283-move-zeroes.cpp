
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int count = 0;
        for(int i = 0;i<nums.size() - count;++i){
            if(nums[i] == 0){
                nums.erase(nums.begin() + i);
                 nums.push_back(0);
                count++;
                i--;
               
            }
        }
        
    }
};