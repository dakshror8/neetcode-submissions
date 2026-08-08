class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        Set<Character> open = new HashSet<>();
        open.add('(');
        open.add('[');
        open.add('{');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);

            // open 
            if(open.contains(curr)){
                stack.push(curr);
            }
            else{
                if(!stack.isEmpty() && stack.peek().equals(closeToOpen.get(curr))){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }
}
