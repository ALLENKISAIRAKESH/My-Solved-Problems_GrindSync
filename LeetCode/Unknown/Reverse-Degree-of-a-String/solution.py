class Solution:
    def reverseDegree(self, s: str) -> int:
        a=0
        for i , ch in enumerate(s,1):
            r = 26 - (ord(ch)-ord('a'))
            a+=i*r
        return a
        