class Solution {
    public int minSubarray(int[] nums, int p) {

        /*
        🔥 APPROACH: PREFIX SUM + HASHMAP (MODULO)

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Let total sum = S
        We need to remove subarray with sum % p = S % p

        ------------------------------------------------

        Let target = S % p

        Now find smallest subarray whose sum % p == target

        ------------------------------------------------

        💡 Trick:

        prefix[j] - prefix[i] ≡ target (mod p)

        ⇒ prefix[i] ≡ (prefix[j] - target) % p

        ------------------------------------------------

        Use hashmap to store:
        remainder → index

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        long sum = 0;
        for (int num : nums) sum += num;

        int target = (int)(sum % p);
        if (target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];
            int curr = (int)(prefix % p);

            int need = (curr - target + p) % p;

            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            map.put(curr, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}