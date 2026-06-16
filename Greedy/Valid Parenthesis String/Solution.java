// Dp solution tc - o(n^2) , sc - O(n^2)
class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int [][] dp=new int[n+1][n+1];

        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(s,0,0,dp);

    }
    static boolean solve(String s,int cnt, int ind, int [][] dp){
        if(cnt<0){
            return false;
        }
        if(ind==s.length()){
            return cnt==0;
        }
        if(dp[cnt][ind]!=-1){
            return dp[cnt][ind]==1;
        }

        if(s.charAt(ind)=='('){
            return solve(s,cnt+1,ind+1,dp);
        }
        if(s.charAt(ind)==')'){
            return solve(s,cnt-1,ind+1,dp);
        }
        
        boolean res= solve(s,cnt+1,ind+1,dp)|| solve(s,cnt,ind+1,dp) || solve(s,cnt-1,ind+1,dp);
          dp[cnt][ind] = res ? 1 : 0;
        return res;
    }
}


// Optimal approach tc - O(n) & sc - O(1)
class Solution {
    public boolean checkValidString(String s) {
        int min=0 ; int max=0; // keep a range
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                min++; max++;
            }else if(ch==')'){
                min--; max--;
            }else{
                min--; max++;
            }
            min=Math.max(min,0);
            if(max<0) return false;
        }
        if(min!=0) return false;
        return true;
    }
}




