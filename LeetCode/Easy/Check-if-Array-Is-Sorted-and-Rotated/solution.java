class Solution {
    public boolean check(int[] nums) {
        int breaks = 0;
        int r = nums.length;
        for(int s =0; s<r;s++){
            if(nums[s] > nums[(s +1)%r]){
                breaks++;
            }
        }
        return breaks <= 1;
    }
}