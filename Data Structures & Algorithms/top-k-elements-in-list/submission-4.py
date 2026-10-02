class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        
        for num in nums:
            freq[num] = 1 + freq.get(num, 0)
        
        max_freq = max(freq.values())
        
        bucket = [[] for _ in range(max_freq + 1)]
        for num, count in freq.items():
            bucket[count].append(num)
        
        res = []
        for i in range(len(bucket)-1, -1, -1):
            for num in bucket[i]:
                res.append(num)
                if len(res) == k:
                    return res
