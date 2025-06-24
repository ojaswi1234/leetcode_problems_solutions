class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
    vector<int> result;
    int n = nums.size();

    // Step 1: Find all indices where nums[i] == key
    vector<int> keyIndices;
    for (int i = 0; i < n; ++i) {
        if (nums[i] == key) {
            keyIndices.push_back(i);
        }
    }

    // Step 2: For each index in nums, check if it's within k distance from any key index
    for (int i = 0; i < n; ++i) {
        for (int idx : keyIndices) {
            if (abs(i - idx) <= k) {
                result.push_back(i);
                break;
            }
        }
    }

    return result;
}

};