class Solution:
    def lexPalindromicPermutation(self, s: str, target: str) -> str:
        n = len(s)
        c = [0] * 26

        for x in s:
            c[ord(x) - 97] += 1

        o = -1
        for i in range(26):
            if c[i] % 2:
                if o != -1:
                    return ""
                o = i

        h = n // 2
        a = [x // 2 for x in c]

        for i in range(h):
            x = ord(target[i]) - 97
            if not a[x]:
                break
            a[x] -= 1
        else:
            p = list(target[:h])
            r = ''.join(p)
            if n % 2:
                r += chr(o + 97)
            r += ''.join(p[::-1])
            if r > target:
                return r

        for i in range(h - 1, -1, -1):
            a = [x // 2 for x in c]

            for j in range(i):
                x = ord(target[j]) - 97
                if not a[x]:
                    break
                a[x] -= 1
            else:
                x = ord(target[i]) - 97

                for y in range(x + 1, 26):
                    if a[y]:
                        p = list(target[:i]) + [chr(y + 97)]
                        a[y] -= 1

                        for z in range(26):
                            p += [chr(z + 97)] * a[z]

                        r = ''.join(p)
                        if n % 2:
                            r += chr(o + 97)
                        r += ''.join(p[::-1])
                        return r

        return ""