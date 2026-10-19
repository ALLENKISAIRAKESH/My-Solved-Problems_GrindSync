class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        o = a = 0
        for c in s:
            if c == '(':
                o += 1
            elif o:
                o -= 1
            else:
                a += 1
        return a + o