class Solution:
    def posInfinite(self, s: str, pos: int) -> str:
        lengths = [len(s)]
        step = 1
        while lengths[-1] < pos:
            lengths.append(2 * lengths[-1] + step)
            step += 1
        step -= 1
        while step > 0:
            old_len = lengths[step - 1]
            new_len = lengths[step]
            if pos <= old_len:
                pass  
            elif pos <= old_len + step:
                return '$'  
            else:
                pos = 2 * old_len + step - pos + 1

            step -= 1

        return s[pos - 1]