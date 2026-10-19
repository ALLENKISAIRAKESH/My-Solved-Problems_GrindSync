class Solution:
    def minInsertions(self, s: str) -> int:
        a = b = 0
        for c in s:
            if c == '(':
                b += 2
                if b % 2:
                    a += 1
                    b -= 1
            else:
                b -= 1
                if b < 0:
                    a += 1
                    b = 1
        return a + b