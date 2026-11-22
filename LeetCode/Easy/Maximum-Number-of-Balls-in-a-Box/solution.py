class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        box_counts = [0] * 46  
        for i in range(lowLimit, highLimit + 1):
            digit_sum = 0
            temp = i
            while temp > 0:
                digit_sum += temp % 10
                temp //= 10
            box_counts[digit_sum] += 1
        return max(box_counts)
