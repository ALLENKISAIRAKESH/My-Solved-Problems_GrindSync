class Solution:
    def findPattern(self, s):
        i = 0
        n = len(s)
        while i < n:
            count = 0
            while i < n and s[i] == 'x':
                count += 1
                i += 1
            if count == 0:
                return False
            for _ in range(count):
                if i >= n or s[i] != 'y':
                    return False
                i += 1
        return True