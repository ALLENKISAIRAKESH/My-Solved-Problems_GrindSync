class Solution:
    def countEven(self, num: int) -> int:
        digit_sum = 0
        n = num
        while n != 0:
            digit_sum += n % 10
            n //= 10
        return (num - 1) // 2 if (digit_sum & 1) == 1 else num // 2