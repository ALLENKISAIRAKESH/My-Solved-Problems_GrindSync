class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] d = new int[2 * limit + 2];
        for (int i = 0; i < n/2;i++){
            int a = nums[i];
            int b =nums[n - 1 -i];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            int sum = a+b;
            d[2] +=2;
            d[low] -= 1;
            d[high + 1] +=1;
            d[sum] -= 1;
            d[sum + 1] += 1;

        }
        int ans = Integer.MAX_VALUE;
        int cur = 0;
        for (int s =2; s <= 2*limit;s++){
            cur += d[s];
            ans = Math.min(ans, cur);
        } 
        return ans;
                       

        
    }
}