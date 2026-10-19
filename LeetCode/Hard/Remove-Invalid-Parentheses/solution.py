class Solution:
    def removeInvalidParentheses(self, s: str) -> list[str]:
        a= set()
        def dfs(i, path, balance):
            if i == len(s):
                if balance == 0:
                    a.add(path)
                return
            if s[i] == '(':
                dfs(i + 1, path + '(', balance + 1)
                dfs(i + 1, path, balance)
            elif s[i] == ')':
                if balance > 0:
                    dfs(i + 1, path + ')', balance - 1)
                dfs(i + 1, path, balance)
            else:
                dfs(i + 1, path + s[i], balance)
        dfs(0, "", 0)
        m = min(len(s) - len(x) for x in a)
        return [x for x in a if len(s) - len(x) == m]