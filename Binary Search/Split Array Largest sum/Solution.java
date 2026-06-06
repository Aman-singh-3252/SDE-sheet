class Solution {
    public int splitArray(int[] nums, int k) {
        int ans=0;
        int start = 0; int end = (int)(1e9);
        while(start<=end){
            int mid = (start+end)/2;
            if(possible(nums,k,mid)){
                ans = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return ans ;
    }

    private boolean possible(int [] nums, int k, int mid){
        int n=nums.length;
        int cnt=1;
        int sum = 0;

        for(int i=0;i<n;i++){
            if(nums[i]>mid) return false; // element itself is greater than mid.
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }else{
                cnt++;
                sum=nums[i];
            }
        }
        return cnt<=k;
    }
}


// striver's code ( works for Book allocation , Painter's Psrtition also).

class Solution {
    public int splitArray(int[] nums, int k) {
        int sum=0;
        int start=Integer.MIN_VALUE; int end=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            start=Math.max(start,nums[i]);
        }
        end=sum;
        int ans=end;
        while(start<=end){
            int mid = start+ (end-start)/2;
            int need= valid(nums,k,mid);
            if(need>k){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }

    static int valid(int [] nums, int k, int maxSum){
        int sum=0;
        int cnt=1;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=maxSum){
                sum+=nums[i];
            }else{
                cnt++;
                sum=nums[i];
            }
        }
        return cnt;
    }
}
