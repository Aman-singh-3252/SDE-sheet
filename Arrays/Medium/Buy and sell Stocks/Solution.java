class Solution {
    public int maxProfit(int[] prices) {
        // optimal 
        int n = prices.length;
        int min=prices[0];
        int profit=0;

        for(int i=1;i<n;i++){
            int cost = prices[i]-min;
            min=Math.min(min,prices[i]);
            profit=Math.max(profit,cost); 
        }

        return profit;
    }
}
