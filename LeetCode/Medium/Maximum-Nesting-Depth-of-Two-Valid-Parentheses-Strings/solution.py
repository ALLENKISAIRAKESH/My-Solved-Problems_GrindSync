class Solution:
    def maxDepthAfterSplit(self, seq: str) -> list[int]:
        a = []
        d = 0
        for char in seq:
            if char == '(':
                d += 1
                a.append(d % 2)
            else:  # char == ')'
                a.append(d % 2)
                d -= 1
        return a