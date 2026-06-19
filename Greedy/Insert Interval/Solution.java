class Solution {
    public int[][] insert(int[][] arr, int[] a) {
        List<int[]> ans = new ArrayList<>();
        int i=0;
        int n = arr.length;
        while(i<n && arr[i][1]<a[0]){
            ans.add(arr[i]);
            i++;
        }
        while(i<n && arr[i][0]<=a[1]){
            a[0]=Math.min(a[0],arr[i][0]);
            a[1]=Math.max(a[1],arr[i][1]);
            i++;
        }
        ans.add(a);

        while(i<n){
            ans.add(arr[i]);
            i++;
        }

        return ans.toArray(new int [ans.size()][2]);
    }
}
