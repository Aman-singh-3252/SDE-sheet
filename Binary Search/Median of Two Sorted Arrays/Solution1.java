// optimizing extra space by using extra variables.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int idx2 = n/2;
        int idx1 = (n/2) - 1;
        int el1=-1; int el2=-1;
        int i=0; int j=0;
        int cnt = 0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                if(cnt==idx1) el1=nums1[i];
                if(cnt==idx2) el2=nums1[i];
                i++;
            }else{
                if(cnt==idx1) el1=nums2[j];
                if(cnt==idx2) el2=nums2[j];
                j++;
            }
            cnt++;
        }
        while(i<n1){
            if(cnt==idx1) el1=nums1[i];
            if(cnt==idx2) el2=nums1[i];
            i++;
            cnt++;
        }

        while(j<n2){
            if(cnt==idx1) el1=nums2[j];
            if(cnt==idx2) el2=nums2[j];
            j++;
            cnt++;
        }

        if(n%2!=0){
            return (double)el2;
        }
        return (double)((double)(el1+el2)/2);
    }
}
