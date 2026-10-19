class Solution:
    def findKthSmallest(self, coins: List[int], k: int) -> int:
        coins.sort()
        useful = []
        for c in coins:
            redundant = False
            for x in useful:
                if c % x == 0:
                    redundant = True
                    break
            if not redundant:
                useful.append(c)
        coins = useful
        n = len(coins)
        def count(x):
            total = 0
            for mask in range(1, 1 << n):
                lcm = 1
                bits = 0
                for i in range(n):
                    if mask & (1 << i):
                        bits += 1
                        lcm = lcm * coins[i] // gcd(lcm, coins[i])
                        if lcm > x:
                            break
                if lcm <= x:
                    if bits % 2:
                        total += x // lcm
                    else:
                        total -= x // lcm
            return total
        left = 1
        right = min(coins) * k
        while left < right:
            mid = (left + right) // 2
            if count(mid) >= k:
                right = mid
            else:
                left = mid + 1
        return left