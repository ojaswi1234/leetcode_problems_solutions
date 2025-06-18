class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if(n % 3 != 0) return new int[0][0];

        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();

        for(int i= 0;i<n;i+=3){
            if(nums[i+2] - nums[i] > k) return new int[0][0];

            res.add(new int[]{nums[i], nums[i+1], nums[i+2]});
        }

        return res.toArray(new int[0][]);
    }
}