class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        temp = x
        result = 0
        while (temp != 0):
            result = temp % 10 + result * 10
            temp //= 10
        
        return result == x