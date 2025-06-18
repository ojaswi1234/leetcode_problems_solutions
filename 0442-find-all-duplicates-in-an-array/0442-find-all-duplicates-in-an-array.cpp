class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        int n = nums.size();
        int i = 0;
        vector<int> arr;
        vector<bool> visited(n, false);
        while(i<n){
            int visit= nums[i]-1;
            if(visit >= 0 && n > visit && nums[i] != nums[visit]){
                swap(nums[i], nums[visit]);
              
            }else{
                i++;
            }
        }
        i = 0;
        while(i < n){
            if(nums[i] != i + 1){
                if(!visited[nums[i] - 1]){
                    arr.push_back(nums[i]);
                    visited[nums[i] - 1] = true;
                }
            }
            i++;
        }
        return arr;
    }
};