class Solution:
    def minimumPushes(self, word: str) -> int:
        a=0
        for i in range(len(word)):
            a = a + i // 8 + 1
        return a