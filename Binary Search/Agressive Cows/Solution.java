class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int start = 1; int end = (int)(1e9);
        int ans = 0;
        while(start<=end){
            int mid = end - (end-start)/2;
            if(canPlace(stalls,k,mid)){
                ans = mid;
                start = mid +1;
            }else{
                end = mid-1;
            }
        }
        return ans;
        
    }
    private boolean canPlace(int [] arr, int cows, int dist){
        int n = arr.length;
      
        int cnt=1; int last = arr[0];
      
        for(int i=1;i<n;i++){
            if(arr[i]-last>=dist){
                cnt++;
                last = arr[i];
            }
        }
        
        if(cnt>=cows) return true;
        return false;
    }
}
