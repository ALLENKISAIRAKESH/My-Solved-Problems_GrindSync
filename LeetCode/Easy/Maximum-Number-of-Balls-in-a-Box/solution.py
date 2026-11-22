class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        box_counts = {}
        max_balls = 0
        for i in range(lowLimit, highLimit + 1):
            temp = i
            digit_sum = 0
            while temp > 0:
                digit_sum += temp % 10
                temp //= 10
            box_counts[digit_sum] = box_counts.get(digit_sum, 0) + 1
            if box_counts[digit_sum] > max_balls:
                max_balls = box_counts[digit_sum]      
        return max_balls