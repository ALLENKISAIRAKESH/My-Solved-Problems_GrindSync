class Solution:
    def generateParenthesis(self, n):
        a= []
        def sol(s, op, cl):
            if len(s) == 2 * n:
                a.append(s)
                return
            if op < n:
                sol(s + "(", op + 1, cl)
            if cl < op:
                sol(s + ")", op, cl + 1)

        sol("", 0, 0)
        return a