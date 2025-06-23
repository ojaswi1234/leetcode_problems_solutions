class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int[] brr = new int[]{};

        int l = 0;
        int h = n - 1;

        //int brr[] = new int[]{};
        
        while(l < h){
            int s = numbers[l] + numbers[h];

            if(s == target){
                return new int[] {l+1, h+1};
            }
            else if(s < target) l++;
            else h--;
        }
        return new int[0];
    }
}