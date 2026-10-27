class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:
        Build number incrementally using modulo

        Instead of full number (overflow ❌),
        keep only remainder mod 5

        ------------------------------------------------

        💡 Formula:
        newValue = (oldValue * 2 + currentBit) % 5

        ------------------------------------------------

        If remainder == 0 → divisible by 5

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        List<Boolean> ans = new ArrayList<>();

        int curr = 0; // current remainder mod 5

        for (int bit : nums) {

            curr = (curr * 2 + bit) % 5;

            ans.add(curr == 0);
        }

        return ans;
    }
}