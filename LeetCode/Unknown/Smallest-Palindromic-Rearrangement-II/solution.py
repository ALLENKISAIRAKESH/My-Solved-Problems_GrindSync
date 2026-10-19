class Solution:
    def smallestPalindrome(self, s: str, k: int) -> str:
        c = Counter(s)
        a = [c[chr(i + 97)] // 2 for i in range(26)]
        m = sum(a)
        t = next((x for x in c if c[x] & 1), "")

        def g():
            r = 1
            x = sum(a)
            for v in a:
                if v:
                    r *= comb(x, v)
                    if r > k:
                        return k + 1
                    x -= v
            return r

        if g() < k:
            return ""

        ans = []
        for _ in range(m):
            for i in range(26):
                if a[i]:
                    a[i] -= 1
                    w = g()
                    if w >= k:
                        ans.append(chr(i + 97))
                        break
                    k -= w
                    a[i] += 1

        l = "".join(ans)
        return l + t + l[::-1]