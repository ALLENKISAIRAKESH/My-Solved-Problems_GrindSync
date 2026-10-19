class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        mp = {')': '(', ']': '[', '}': '{'}
        for c in s:
            if c in '([{':
                st.append(c)
            else:
                if not st or st[-1] != mp[c]:
                    return False
                st.pop()
        return not st