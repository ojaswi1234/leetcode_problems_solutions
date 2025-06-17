class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> arr;
        int n = nums.size();
        int i = 1;
        while(i < n){
            int correct = nums[i] - 1;

            if(n > correct && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else{
                i++;
            }
        }
        for(int i = 0;i<n;i++){
            if(nums[i] != i + 1){
                arr.push_back(i + 1);
            }
        }
        
        return arr;
    }
};