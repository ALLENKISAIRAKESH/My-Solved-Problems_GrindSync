class Solution:
    def sortIt(self, arr):
        o = sorted([x for x in arr if x % 2 != 0], reverse=True)
        e = sorted([x for x in arr if x % 2 == 0])
        arr[:] = o + e
        return arr