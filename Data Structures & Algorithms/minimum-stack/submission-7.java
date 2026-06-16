class MinStack {
    Stack<Long> data;
    long minEle;
    public MinStack() {
        data = new Stack<>();
    }
    
    public void push(int val) {
        long x = val;
        if(data.isEmpty()){
            data.push(x);
            minEle = x;
        }
        else{
            if(x >= minEle){
                data.push(x);
            }
            else{
                data.push(2L*x - minEle);
                minEle = x;
            }
        }
    }
    
    public void pop() {
        if(data.isEmpty()){
            return;
        }
        else{
            if(data.peek() < minEle){
                minEle = 2L*minEle - data.peek();
                data.pop();
            }
            else{
                data.pop();
            }
        }
    }
    
    public int top() {
        if(data.isEmpty()){
            return -1;
        }
        else{
            
            if(data.peek() < minEle){
                return (int)minEle;
            }
            else{
                long top = data.peek();
                return (int)top;
            }
        }
    }
    
    public int getMin() {
        if(data.isEmpty()){
            return -1;
        }
        return (int)minEle;
    }
}
