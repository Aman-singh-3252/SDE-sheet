class Solution {
    public int maxProduct(int[] arr) {
        // intuition
        // for max just handle the 0 case, otherwise the max would be whole array

        // if whole array is -ve , the ans is either prod except first negative or prod except last negative.
        int pre=1;
        int suf=1;
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(pre==0) pre=1;
            if(suf==0) suf=1;

            pre= pre*arr[i];
            suf= suf*arr[n-i-1];
            ans=Math.max(ans,Math.max(pre,suf));
        }

        return ans;
    }
}
