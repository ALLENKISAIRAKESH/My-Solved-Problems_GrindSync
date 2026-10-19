class Solution:
    def smallestNumber(self, num: str, t: int) -> str:
        temp_t = t
        counts = {2: 0, 3: 0, 5: 0, 7: 0}
        for p in [2, 3, 5, 7]:
            while temp_t % p == 0:
                counts[p] += 1
                temp_t //= p
        
        if temp_t > 1:
            return "-1"

        def get_min_digits(a: int, b: int, c: int, d: int) -> list[int]:
            digits = []
            digits.extend([7] * d)
            digits.extend([5] * c)
            
            cnt8 = a // 3
            rem2 = a % 3
            cnt9 = b // 2
            rem3 = b % 2
            
            if rem2 == 2 and rem3 == 1:
                digits.append(6)
                digits.append(2)
                rem2, rem3 = 0, 0
            elif rem2 == 1 and rem3 == 1:
                digits.append(6)
                rem2, rem3 = 0, 0
            elif rem2 == 2 and rem3 == 0:
                digits.append(4)
                rem2 = 0
            elif rem2 == 1 and rem3 == 0:
                digits.append(2)
                rem2 = 0
            elif rem2 == 0 and rem3 == 1:
                digits.append(3)
                rem3 = 0

            digits.extend([8] * cnt8)
            digits.extend([9] * cnt9)
            digits.sort()
            return digits

        n = len(num)
        
        pref_factors = [(0, 0, 0, 0)] * (n + 1)
        first_zero = n
        
        c2, c3, c5, c7 = 0, 0, 0, 0
        for i, ch in enumerate(num):
            d = int(ch)
            if d == 0:
                first_zero = i
                break
            if d == 2: c2 += 1
            elif d == 3: c3 += 1
            elif d == 4: c2 += 2
            elif d == 5: c5 += 1
            elif d == 6: c2 += 1; c3 += 1
            elif d == 7: c7 += 1
            elif d == 8: c2 += 3
            elif d == 9: c3 += 2
            
            pref_factors[i + 1] = (c2, c3, c5, c7)

        def get_rem(p2, p3, p5, p7):
            return (
                max(0, counts[2] - p2),
                max(0, counts[3] - p3),
                max(0, counts[5] - p5),
                max(0, counts[7] - p7)
            )

        if first_zero == n:
            r2, r3, r5, r7 = get_rem(*pref_factors[n])
            if r2 == 0 and r3 == 0 and r5 == 0 and r7 == 0:
                return num

        for i in range(min(n - 1, first_zero), -1, -1):
            p2, p3, p5, p7 = pref_factors[i]
            start_digit = int(num[i]) + 1
            
            for next_d in range(start_digit, 10):
                nd2, nd3, nd5, nd7 = 0, 0, 0, 0
                if next_d == 2: nd2 = 1
                elif next_d == 3: nd3 = 1
                elif next_d == 4: nd2 = 2
                elif next_d == 5: nd5 = 1
                elif next_d == 6: nd2 = 1; nd3 = 1
                elif next_d == 7: nd7 = 1
                elif next_d == 8: nd2 = 3
                elif next_d == 9: nd3 = 2

                r2, r3, r5, r7 = get_rem(p2 + nd2, p3 + nd3, p5 + nd5, p7 + nd7)
                suffix_len = n - 1 - i
                
                needed_digits = get_min_digits(r2, r3, r5, r7)
                if len(needed_digits) <= suffix_len:
                    ones_count = suffix_len - len(needed_digits)
                    suffix_str = "1" * ones_count + "".join(map(str, needed_digits))
                    return num[:i] + str(next_d) + suffix_str

        target_len = n + 1
        r2, r3, r5, r7 = get_rem(0, 0, 0, 0)
        needed_digits = get_min_digits(r2, r3, r5, r7)
        
        target_len = max(target_len, len(needed_digits))
        ones_count = target_len - len(needed_digits)
        
        return "1" * ones_count + "".join(map(str, needed_digits))