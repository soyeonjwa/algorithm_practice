import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int keep =  number.length()-k;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<number.length();i++){
            while(!stack.isEmpty() && k>0 && stack.peek()<number.charAt(i)){
                k--;
                stack.pop();
            }
            stack.push(number.charAt(i));
        }
        
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()); 
        }
        return sb.reverse().substring(0, keep);
    }
}