class Solution {
    public int furthestDistanceFromOrigin(String m) {
        int l = 0, r =0, u =0;
        for (char c:m.toCharArray()){
            if ( c=='L')l++;
            else if (c=='R')r++;
            else u++;
        }
          return Math.abs(r-l)+u;
    
        
    }
}