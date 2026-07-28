class Solution {
    static int cnt=0;
    public static void merge(int [] nums, int left, int mid, int right){
        int n = nums.length;
        int [] temp = new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
        }

        while(j<=right){
            temp[k++]=nums[j++];
        }

        for(int p=0;p<temp.length;p++){
            nums[left+p]=temp[p];
        }

    }
    public static void countPairs(int [] nums, int left, int mid, int right){
        int j=mid+1;
        for(int i=left;i<=mid;i++){
            while(j<=right && (long)nums[i]>2L*nums[j]){
                j++;
            }
            cnt+=(j-(mid+1));
        }
    }
    public static void mergeSort(int [] nums, int left, int right){
        if(left>=right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        countPairs(nums,left,mid, right);
        merge(nums,left,mid,right);
    }
    public int reversePairs(int[] nums) {
        cnt=0;
        int n = nums.length;
        mergeSort(nums,0,n-1);
        return cnt;
    }
}
