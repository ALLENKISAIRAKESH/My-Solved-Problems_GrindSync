class Solution:
    def reverse(self, x: int) -> int:
        res, sign = 0, -1 if x < 0 else 1
        x = abs(x)
        while x:
            if res > (2**31 - 1) // 10:
                return 0 
            res = res * 10 + x % 10
            x //= 10
        return sign * res
solution = Solution()
print(solution.reverse(123))  
print(solution.reverse(-123))  
print(solution.reverse(120))   
