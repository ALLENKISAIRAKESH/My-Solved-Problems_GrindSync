class Solution {
    public boolean canReach(int[] a, int s) {
        if(s<0||s>=a.length||a[s]==-1){
            return false;
        }
        if (a[s]==0){
            return true;
        }
        int j =a[s];
        a[s] =-1;
        return canReach(a,s+j)||canReach(a,s-j);
    }
}