class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq= {}
        maxFreq = 0
        for num in nums:
            freq[num] = 1 + freq.get(num,0)
            maxFreq = max(maxFreq, freq[num])
        
        bucket = [[] for _ in range(maxFreq+1)]

        for num, count in freq.items():
            bucket[count].append(num)
        
        res = []
        for i in range(maxFreq, -1, -1):
            for num in bucket[i]:
                res.append(num)
                if(len(res) == k):
                    return res