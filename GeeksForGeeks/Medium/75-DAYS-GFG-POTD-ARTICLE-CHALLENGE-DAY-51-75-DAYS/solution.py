''' 
Structure of a Binary Search Tree node
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
'''


class Solution:
    def findCommon(self, r1: 'Node', r2: 'Node') -> list[int]:
        s1, s2 = [], []
        ans = []
        while True:
            while r1:
                s1.append(r1)
                r1 = r1.left
            while r2:
                s2.append(r2)
                r2 = r2.left
            if not s1 or not s2:
                break
            a = s1[-1]
            b = s2[-1]
            if a.data == b.data:
                ans.append(a.data)
                r1 = s1.pop().right
                r2 = s2.pop().right
            elif a.data < b.data:
                r1 = s1.pop().right
            else:
                r2 = s2.pop().right
        return ans