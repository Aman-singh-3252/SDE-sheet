class Solution {
    // brute force , tc = 3n , sc - O(2*n).
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] pre = new int [n];
        int [] suf = new int [n];
        int cnt = 1;
        pre[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                cnt++;
                pre[i]=cnt;
            }else{
                cnt=1;
                pre[i]=cnt;
            }
        }
        suf[n-1]=1;
        cnt=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                cnt++;
                suf[i]=cnt;
            }else{
                cnt=1;
                suf[i]=cnt;
            }
        }

        int ans = 0;
        for(int i=0;i<ratings.length;i++){
            ans+=Math.max(pre[i],suf[i]);
        }

        return ans;
    }
}


// optimal solution using slope...

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum=1; int i=1;

        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum++; i++; continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1; i++; sum+=peak;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down ; i++; down+=1;
            }
            if(down>peak){
                sum+=down-peak;
            }
        }

        return sum;
    }
}

