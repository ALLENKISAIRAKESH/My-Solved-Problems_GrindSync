class Solution:
    def largestSumCycle(self, edge):
        # code here
        n = len(edge)
        visited = [False] * n
        max_sum = -1
        for i in range(n):
            if visited[i]:
                continue
            curr = i
            path = {}
            path_sum = 0
            while curr != -1 and not visited[curr]:
                visited[curr] = True
                path[curr] = path_sum
                path_sum += curr
                curr = edge[curr]
            if curr != -1 and curr in path:
                cycle_sum = 0
                node = curr
                while True:
                    cycle_sum += node
                    node = edge[node]
                    if node == curr:
                        break
                max_sum = max(max_sum, cycle_sum)
        return max_sum