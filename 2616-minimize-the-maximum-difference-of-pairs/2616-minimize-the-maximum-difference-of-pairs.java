import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid; // Reduce the max difference
            } else {
                left = mid + 1; // Increase allowable max difference
            }
        }

        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i++; // Skip the next index to avoid reuse
            }
        }
        return count >= p;
    }
}
