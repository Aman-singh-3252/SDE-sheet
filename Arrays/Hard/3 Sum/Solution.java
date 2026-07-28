class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;

        List<List<Integer>>ans=new ArrayList<>();

        //sort
        Arrays.sort(arr);

        //fixing one element
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int n1=arr[i];
            int target=-n1;

            twoSum(arr,target,i+1,n-1,ans);//find n2 and n3

        }
        return ans;
    }
    static void twoSum(int [] arr, int target, int i, int j,List<List<Integer>>ans){
        while(i<j){
            if(arr[i]+arr[j]>target){
                j--;
            }else if(arr[i]+arr[j]<target){
                i++;
            }else{
                //first we will remove duplicate
                while(i<j && arr[i]==arr[i+1]) i++;
                while(i<j && arr[j]==arr[j-1]) j--;
                ans.add(Arrays.asList(-target, arr[i], arr[j]));
                i++; j--;
            }
        }
    }
}

   



    
