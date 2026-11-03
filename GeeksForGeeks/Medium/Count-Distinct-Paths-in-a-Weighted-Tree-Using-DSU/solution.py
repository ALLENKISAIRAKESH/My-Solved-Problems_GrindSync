class Solution:
    def maximumWeight(self, n, edges, queries):
        # code here
        edges.sort(key=lambda e: e[2])
        parent = list(range(n + 1))
        size = [1] * (n + 1)
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        ans = []
        j = 0
        paths = 0
        for x in sorted(enumerate(queries), key=lambda q: q[1]):
            idx, limit = x
            while j < len(edges) and edges[j][2] <= limit:
                u, v, w = edges[j]
                ru = find(u)
                rv = find(v)
                if ru != rv:
                    paths += size[ru] * size[rv]
                    if size[ru] < size[rv]:
                        ru, rv = rv, ru
                    parent[rv] = ru
                    size[ru] += size[rv]
                j += 1
            ans.append((idx, paths))
        ans.sort()
        return [value for idx, value in ans]