class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int iPtr = 0;
        int jPtr = 0;
        int maxGap = 0;
        while (iPtr < nums1.length && jPtr < nums2.length ) {
            if (nums1[iPtr] <= nums2[jPtr]) {
                int currentGap = jPtr - iPtr;
                
                if (currentGap > maxGap) {
                    maxGap = currentGap;
                  
                }
                jPtr++;


            } else {
                iPtr++;

            }
        }
        return maxGap;
    }
}