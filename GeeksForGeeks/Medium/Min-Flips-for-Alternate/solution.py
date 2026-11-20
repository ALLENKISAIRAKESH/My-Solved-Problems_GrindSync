class Solution:
    def minFlips(self, s):
        flips1 = 0
        flips2 = 0
        for i in range(len(s)):
            if i % 2 == 0:
                if s[i] != '0':
                    flips1 += 1
                if s[i] != '1':
                    flips2 += 1
            else:
                if s[i] != '1':
                    flips1 += 1
                if s[i] != '0':
                    flips2 += 1
        return min(flips1, flips2)