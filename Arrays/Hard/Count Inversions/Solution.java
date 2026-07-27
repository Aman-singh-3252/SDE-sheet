class Solution {
    static int cnt = 0;
     public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // right is smaller here.
                cnt+= (mid-i+1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
    
    public int inversionCount(int arr[]) {
        cnt=0;
        int n = arr.length;
        mergeSort(arr,0,n-1);
        return cnt;
        
        
    }
}




