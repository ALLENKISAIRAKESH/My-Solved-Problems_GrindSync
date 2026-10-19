class Solution:
    def lexGreaterPermutation(self, s: str, target: str) -> str:
        cnt = [0] * 26

        for ch in s:
            cnt[ord(ch) - ord('a')] += 1

        n = len(s)
        ans = []

        # Try to match target from left to right
        for i in range(n):
            t = ord(target[i]) - ord('a')

            # If we can use target[i], continue matching
            if cnt[t] > 0:
                ans.append(target[i])
                cnt[t] -= 1
                continue

            # We cannot match target[i].
            # Find the smallest available character > target[i].
            bigger = -1
            for c in range(t + 1, 26):
                if cnt[c] > 0:
                    bigger = c
                    break

            if bigger != -1:
                ans.append(chr(bigger + ord('a')))
                cnt[bigger] -= 1

                # Fill the rest with the smallest possible characters
                for c in range(26):
                    ans.extend([chr(c + ord('a'))] * cnt[c])

                return ''.join(ans)

            # No character >= target[i] can work here.
            # We need to backtrack and increase an earlier character.

            break

        # Backtracking:
        # Try changing the previous matched positions.
        for i in range(len(ans) - 1, -1, -1):
            current = ord(ans[i]) - ord('a')
            cnt[current] += 1

            # Find the smallest available character greater than ans[i]
            for c in range(current + 1, 26):
                if cnt[c] > 0:
                    result = ans[:i]
                    result.append(chr(c + ord('a')))
                    cnt[c] -= 1

                    # Remaining characters in sorted order
                    for x in range(26):
                        result.extend([chr(x + ord('a'))] * cnt[x])

                    return ''.join(result)

        return ""