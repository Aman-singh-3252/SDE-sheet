// optimal solution.

class Solution {
    public boolean canJump(int[] nums) {
        int n =nums.length;
        int max=-1;

        for(int i=0;i<n-1;i++){
            max=Math.max(max,nums[i]+i);
            if(nums[i]==0){
                if(max<=i){ // even the maximum jump only get you to the index having 0.
                    return false;
                }
            }
        }
        return true;

    }
}
