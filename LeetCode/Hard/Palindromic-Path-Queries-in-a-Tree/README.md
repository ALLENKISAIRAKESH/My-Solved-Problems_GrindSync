# Palindromic Path Queries in a Tree

| Field | Value |
|-------|-------|
| Platform | LeetCode |
| Difficulty | Hard |
| Language | tag |
| URL | [https://leetcode.com/problems/palindromic-path-queries-in-a-tree/](https://leetcode.com/problems/palindromic-path-queries-in-a-tree/) |
| Submitted | 2026-10-29T15:15:13.750Z |


## Problem Statement

You are given an undirected tree with n nodes labeled 0 to n - 1. This is represented by a 2D array edges of length n - 1, where edges[i] = [ui, vi] indicates an undirected edge between nodes ui and vi.

You are also given a string s of length n consisting of lowercase English letters, where s[i] represents the character assigned to node i.

You are also given a string array queries, where each queries[i] is either:


	"update ui c": Change the character at node ui to c. Formally, update s[ui] = c.
	"query ui vi": Determine whether the string formed by the characters on the unique path from ui to vi (inclusive) can be rearranged into a palindrome.


Return a boolean array answer, where answer[j] is true if the jth query of type "query ui vi"​​​​​​​ can be rearranged into a palindrome, and false otherwise.

 
Example 1:


Input: n = 3, edges = [[0,1],[1,2]], s = "aac", queries = ["query 0 2","update 1 b","query 0 2"]

Output: [true,false]

Explanation:


	"query 0 2": Path 0 → 1 → 2 gives "aac", which can be rearranged to form "aca", a palindrome. Thus, answer[0] = true.
	"update 1 b": Update node 1 to 'b', now s = "abc".
	"query 0 2": Path characters are "abc", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.


Thus, answer = [true, false].


Example 2:


Input: n = 4, edges = [[0,1],[0,2],[0,3]], s = "abca", queries = ["query 1 2","update 0 b","query 2 3","update 3 a","query 1 3"]

Output: [false,false,true]

Explanation:


	"query 1 2": Path 1 → 0 → 2 gives "bac", which cannot be rearranged to form a palindrome. Thus, answer[0] = false.
	"update 0 b": Update node 0 to 'b', now s = "bbca".
	"query 2 3": Path 2 → 0 → 3 gives "cba", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.
	"update 3 a": Update node 3 to 'a', s = "bbca".
	"query 1 3": Path 1 → 0 → 3 gives "bba", which can be rearranged to form "bab", a palindrome. Thus, answer[2] = true.


Thus, answer = [false, false, true].


 
Constraints:


	1 <= n == s.length <= 5 * 104
	edges.length == n - 1
	edges[i] = [ui, vi]
	0 <= ui, vi <= n - 1
	s consists of lowercase English letters.
	The input is generated such that edges represents a valid tree.
	1 <= queries.length <= 5 * 104​​​​​​​
	
		queries[i] = "update ui c" or
		queries[i] = "query ui vi"
		0 <= ui, vi <= n - 1
		c is a lowercase English letter.

## Solution

```tag
class Solution:
    def palindromePath(self, n: int, edges: list[list[int]], s: str, queries: list[str]) -> list[bool]:
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        LOG = n.bit_length()
        tin = [0] * n
        tout = [0] * n
        depth = [0] * n
        up = [[0] * n for _ in range(LOG)]
        timer = 0

        # Iterative DFS to avoid recursion-depth issues
        stack = [(0, -1, 0)]
        while stack:
            u, p, state = stack.pop()

            if state == 0:
                tin[u] = timer
                timer += 1
                up[0][u] = u if p == -1 else p

                for k in range(1, LOG):
                    up[k][u] = up[k - 1][up[k - 1][u]]

                stack.append((u, p, 1))
                for v in reversed(adj[u]):
                    if v != p:
                        depth[v] = depth[u] + 1
                        stack.append((v, u, 0))
            else:
                tout[u] = timer - 1

        def lca(u, v):
            if depth[u] < depth[v]:
                u, v = v, u

            diff = depth[u] - depth[v]
            for k in range(LOG):
                if diff & (1 << k):
                    u = up[k][u]

            if u == v:
                return u

            for k in range(LOG - 1, -1, -1):
                if up[k][u] != up[k][v]:
                    u = up[k][u]
                    v = up[k][v]

            return up[0][u]

        # Fenwick tree storing XOR bitmasks
        bit = [0] * (n + 1)

        def add(i, val):
            i += 1
            while i <= n:
                bit[i] ^= val
                i += i & -i

        def prefix(i):
            res = 0
            i += 1
            while i > 0:
                res ^= bit[i]
                i -= i & -i
            return res

        def range_xor(l, r):
            if l > r:
                return 0
            return prefix(r) ^ (prefix(l - 1) if l else 0)

        chars = list(s)
        masks = [1 << (ord(c) - ord('a')) for c in chars]

        for u in range(n):
            add(tin[u], masks[u])

        ans = []

        for q in queries:
            parts = q.split()

            if parts[0] == "update":
                u = int(parts[1])
                c = parts[2]
                new_mask = 1 << (ord(c) - ord('a'))

                if masks[u] != new_mask:
                    add(tin[u], masks[u] ^ new_mask)
                    masks[u] = new_mask
                    chars[u] = c

            else:
                u, v = int(parts[1]), int(parts[2])
                w = lca(u, v)

                # XOR of root-to-node paths
                path_mask = (
                    range_xor(0, tin[u])
                    ^ range_xor(0, tin[v])
                    ^ masks[w]
                )

                # At most one character may have an odd frequency
                ans.append((path_mask & (path_mask - 1)) == 0)

        return ans
```

---

*Explanation generated by CodeSync — AI explanation will be added once the OpenAI service is enabled.*