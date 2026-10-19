class Solution:
    def sumGame(self, num: str) -> bool:
        n = len(num) // 2
        diff = 0
        q = 0

        for i, ch in enumerate(num):
            if ch == '?':
                q += 1 if i < n else -1
            else:
                diff += int(ch) if i < n else -int(ch)

        return abs(2 * diff + 9 * q) > 0