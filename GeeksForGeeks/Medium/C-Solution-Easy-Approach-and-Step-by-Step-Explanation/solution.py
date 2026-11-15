class Solution:
    def subsequenceSum(self, s):
        MOD = 10**9 + 7
        total = sum(int(digit) for digit in s)
        n = len(s)
        return (total * pow(2, n - 1, MOD)) % MOD