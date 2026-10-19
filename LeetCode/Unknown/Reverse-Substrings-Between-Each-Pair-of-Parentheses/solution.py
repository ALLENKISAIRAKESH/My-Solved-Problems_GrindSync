class Solution:
    def reverseParentheses(self, s: str) -> str:
        st = []
        for c in s:
            if c == '(':
                st.append("")
            elif c == ')':
                x = st.pop()[::-1]
                if st:
                    st[-1] += x
                else:
                    st.append(x)
            else:
                if st:
                    st[-1] += c
                else:
                    st.append(c)
        return ''.join(st)