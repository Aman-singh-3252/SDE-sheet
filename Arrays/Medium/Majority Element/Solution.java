class Solution {
    public int majorityElement(int[] arr) {
        //moore's vooting algorithm
        int n=arr.length;
        int cnt=0; 
        int el=0;

        for(int i=0;i<n;i++){
            if(cnt==0){
                el=arr[i];
                cnt=1;
            }else if(arr[i]==el){
                cnt++;
            }else{
                cnt--;
            }
        }

        return el;
    }
}
