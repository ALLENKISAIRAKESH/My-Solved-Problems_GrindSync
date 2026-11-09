class Solution:
    def getCount(self, s, k):
        freq = [0] * 26
        for i in range(len(s)):
            if i == 0 or s[i] != s[i - 1]:
                freq[ord(s[i]) - ord('a')] += 1
        return sum(1 for x in freq if x == k)