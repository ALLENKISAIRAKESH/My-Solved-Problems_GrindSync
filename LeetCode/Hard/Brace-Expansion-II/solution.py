class Solution:
    def braceExpansionII(self, expression: str) -> list[str]:
        def f(i):
            a = {""}
            b = set()
            while i < len(expression) and expression[i] != '}':
                if expression[i] == '{':
                    c, i = f(i + 1)
                elif expression[i] == ',':
                    b |= a
                    a = {""}
                    i += 1
                    continue
                else:
                    c = {expression[i]}
                    i += 1
                a = {x + y for x in a for y in c}
            b |= a
            return b, i + 1
        return sorted(f(0)[0])