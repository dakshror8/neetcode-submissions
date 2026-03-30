class MinStack {
    Stack<Integer> data;
    Stack<Integer> prevMin;
    public MinStack() {
        data = new Stack<>();
        prevMin = new Stack<>();
        prevMin.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        data.push(val);
        prevMin.push(Math.min(val,prevMin.peek()));
    }
    
    public void pop() {
        if(!data.isEmpty()){
            data.pop();
            prevMin.pop();
        }
    }
    
    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        return -1;
    }
    
    public int getMin() {
        
            return prevMin.peek();
        
    }
}
