class Solution {

    public int totalWaviness(int num1, int num2) {

        int ans = 0;

        for (int num = num1; num <= num2; num++) {

            int n = num;

            if (n < 100) continue;

            while (n >= 100) {

                int right = n % 10;
                int mid = (n / 10) % 10;
                int left = (n / 100) % 10;

                if ((mid > left && mid > right) ||
                    (mid < left && mid < right)) {
                    ans++;
                }

                n /= 10;
            }
        }

        return ans;
    }
}
