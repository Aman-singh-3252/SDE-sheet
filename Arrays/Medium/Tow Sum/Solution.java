class Solution {
    public int[] twoSum(int[] arr, int target) {
         int [] brr=new int[2];
       HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(target-arr[i])){
                map.put(arr[i],i);
            }else{
                brr[0]=i;
                brr[1]=map.get(target-arr[i]);
                break;
            }
        }
        return brr;
        
    }
}
