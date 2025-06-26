
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bd = 0;
        int m = Integer.MAX_VALUE;
        for(int price : prices){
            if(price < m){
                m = price;
            }else if(price - m > bd){
                bd = price - m;
            }
        }

        return bd;


    }
}