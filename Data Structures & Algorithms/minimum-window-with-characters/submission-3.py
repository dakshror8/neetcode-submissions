class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""

        s_map, window = {}, {}

        for c in t:
            s_map[c] = 1 + s_map.get(c, 0)
        
        match_set = set()

        res, resLen = [-1, -1], float("infinity")

        l = 0
        for r in range(len(s)):
            curr = s[r]
            window[curr] = 1 + window.get(curr, 0)

            if curr in s_map and window[curr] == s_map[curr]:
                match_set.add(curr)
            
            while len(match_set) == len(s_map):
                
                if (r-l+1) < resLen:
                    res = [l,r]
                    resLen = r-l+1

                # shrink to get min str
                left_char = s[l]
                window[left_char] = window.get(left_char) - 1

                if left_char in s_map and window[left_char] < s_map[left_char]:
                    match_set.remove(left_char)
                
                l += 1

        l, r = res
        return s[l : r+1] if resLen != float("infinity") else ""
