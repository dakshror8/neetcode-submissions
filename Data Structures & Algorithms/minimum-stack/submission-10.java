class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> min;

    public MinStack() {
        mainStack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        int top = mainStack.pop();
        if(!min.isEmpty() && top == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return min.isEmpty() ? -1 : min.peek();
    }
}
