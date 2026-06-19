class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v=new ArrayList<>();

        for(int [] it:intervals){
            int start = it[0];
            int end = it[1];
            if(v.isEmpty()){
                v.add(start);
                v.add(end);
            }else{
                if(start<=v.get(1)){
                    v.set(1,Math.max(end,v.get(1)));
                }else{
                    ans.add(new ArrayList<>(v));
                    v.clear();
                    v.add(start);
                    v.add(end);
                }
            }
        }

        if(!v.isEmpty()){
            ans.add(new ArrayList<>(v));
        }

        int [][] res = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i][0]=ans.get(i).get(0);
            res[i][1]=ans.get(i).get(1);
        }

        return res;
    }
}
