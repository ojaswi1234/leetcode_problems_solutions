class Solution {
public:
    int missingNumber(vector<int>& nums) {
          int i = 0;
    int n = nums.size();

    while (i < n) {
        int correct = nums[i];
        if (correct < n && nums[i] != nums[correct]) {
            swap(nums[i], nums[correct]);
        } else {
            i++;
        }
    }

    // After sorting, the first index where nums[i] != i is the missing number
    for (int i = 0; i < n; i++) {
        if (nums[i] != i) return i;
    }

    // If all indices are correct, then n is the missing number
    return n;
    }
};