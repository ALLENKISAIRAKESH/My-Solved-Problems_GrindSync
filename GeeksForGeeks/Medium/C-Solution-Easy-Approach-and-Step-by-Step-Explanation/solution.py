class Solution:
    def checkPath(self, adj: list[list[int]], u: int, v: int) -> bool:
        visited = [False] * len(adj)
        stack = [u]
        visited[u] = True

        while stack:
            node = stack.pop()

            if node == v:
                return True

            for nei in adj[node]:
                if not visited[nei]:
                    visited[nei] = True
                    stack.append(nei)

        return False