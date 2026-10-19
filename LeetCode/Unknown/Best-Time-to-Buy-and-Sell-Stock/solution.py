class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        min_price = float('inf')
        ans = 0
        for price in prices:
            min_price = min(min_price, price)
            ans = max(ans, price - min_price)
        return ans