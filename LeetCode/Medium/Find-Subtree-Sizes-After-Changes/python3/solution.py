class Solution:
    def findSubtreeSizes(self, parent: List[int], s: str) -> List[int]:
        n = len(parent)
        children = [[] for _ in range(n)]
        for i in range(1, n):
            children[parent[i]].append(i)
        new_parent = parent[:]
        last = [-1] * 26
        def dfs1(node):
            c = ord(s[node]) - ord('a')
            prev = last[c]
            if prev != -1:
                new_parent[node] = prev
            last[c] = node
            for child in children[node]:
                dfs1(child)
            last[c] = prev
        dfs1(0)
        new_children = [[] for _ in range(n)]
        for i in range(1, n):
            new_children[new_parent[i]].append(i)
        ans = [0] * n
        def dfs2(node):
            ans[node] = 1
            for child in new_children[node]:
                ans[node] += dfs2(child)
            return ans[node]
        dfs2(0)
        return ans