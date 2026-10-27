class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int s  = 0, r = 0;
        while(s<nums1.length && r<nums2.length) {
            if(nums1[s] == nums2[r]){
                return nums1[s];
            }
            else if (nums1[s] < nums2[r]){
                s++;
            }
            else {
                r++;
            }
        }
        return -1;
    }
}