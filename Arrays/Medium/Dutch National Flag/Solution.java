class Solution {
    public void sortColors(int[] arr) {
        //using dutch national flag algorithm
        int low=0; int mid=0; int high=arr.length-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++; mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                swap(arr,mid,high);
                high--;
            }
        }
        return;
    }
    static void swap(int [] arr, int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
