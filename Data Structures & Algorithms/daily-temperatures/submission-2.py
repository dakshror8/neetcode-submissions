class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        output = []
        output.append(0)

        stack = [] # index
        stack.append(len(temperatures) - 1)

        i = len(temperatures) - 2
        while(i >= 0):
            
            while stack and temperatures[i] >= temperatures[stack[-1]]:
                stack.pop()
            
            if stack and temperatures[i] < temperatures[stack[-1]]:
                output.append(stack[-1] - i)
                stack.append(i)
            
            if not stack:
                output.append(0)  
                
            stack.append(i)
            i -= 1
        
        output.reverse()
        return output