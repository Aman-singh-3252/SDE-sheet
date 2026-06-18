
class Solution {
    public int jump(int[] nums) {
        int l=0; int r=0;// take a range 
        int n = nums.length;

        int jumps=0;

        while(r<n-1){
            int far=0;

            for(int i=l;i<=r;i++){
                far= Math.max(far,i+nums[i]); // maximum range.
            }

            l=r+1; r=far; // l will be one ahead of r and r will be at fartest.
            jumps++; 
        }

        return jumps;
    }
}

