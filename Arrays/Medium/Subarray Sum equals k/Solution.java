class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int count=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            if(map.containsKey(sum)){
                 map.put(sum,map.get(sum)+1);
            }else{
               
                map.put(sum,1);
            }
        }
        return count;
    }
}
