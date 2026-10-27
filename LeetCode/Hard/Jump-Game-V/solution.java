class Solution {
    
    int[] dp;
    
    public int maxJumps(int[] a, int d) {
        
        int n=a.length,ans=1;
        dp=new int[n];
        
        for(int i=0;i<n;i++)
            ans=Math.max(ans,f(a,d,i));
        
        return ans;
    }
    
    int f(int[] a,int d,int i){
        
        if(dp[i]!=0) return dp[i];
        
        int ans=1;
        
        for(int j=i+1;j<=Math.min(i+d,a.length-1);j++){
            
            if(a[j]>=a[i]) break;
            
            ans=Math.max(ans,1+f(a,d,j));
        }
        
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            
            if(a[j]>=a[i]) break;
            
            ans=Math.max(ans,1+f(a,d,j));
        }
        
        return dp[i]=ans;
    }
}