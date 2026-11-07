class Solution:
    def generateUsernames(self, arr: list[str]) -> list[str]:
        used = set(arr)
        count = {}
        ans = []
        for name in arr:
            if name not in count:
                ans.append(name)
                count[name] = 1
            else:
                k = count[name]
                while name + str(k) in used:
                    k += 1
                new_name = name + str(k)
                ans.append(new_name)
                used.add(new_name)
                count[name] = k + 1
        return ans