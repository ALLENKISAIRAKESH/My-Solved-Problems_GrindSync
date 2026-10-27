class Solution {
    public int minimumEffort(int[][] t) {
        Arrays.sort(t,(a,b)->
        (b[1]-b[0])-(a[1]-a[0])
        );
        int ans=0,cur=0;
        for(int[] x:t){
            if(cur<x[1]){
                ans+=x[1]-cur;
                cur=x[1];
            }
            cur-=x[0];
        }

        return ans;
    }
}