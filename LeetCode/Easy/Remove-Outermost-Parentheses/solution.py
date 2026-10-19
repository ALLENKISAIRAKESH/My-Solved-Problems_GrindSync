class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        r = ""
        d = 0
        for c in s:
            if c == '(':
                if d > 0:
                    r += c
                d += 1
            else:
                d -= 1
                if d > 0:
                    r += c
        return r