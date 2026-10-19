class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        boxes = [0] * 46
        for n in range(lowLimit, highLimit + 1):
            boxes[sum(map(int, str(n)))] += 1
        return max(boxes)