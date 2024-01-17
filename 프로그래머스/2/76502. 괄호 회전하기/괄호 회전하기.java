import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        Deque<Character> dq = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++) dq.addLast(s.charAt(i));
        
        char tmp;
        for(int r=0;r<s.length();r++){            
            tmp = dq.pollFirst();
            dq.addLast(tmp);
            
            Stack<Character> stack = new Stack<>();
            
            boolean flag = true;
            LABEL: for(char c: dq){
                
                if(c=='{' || c=='[' || c=='(') stack.push(c);
                else{
                    if(stack.isEmpty()){
                        flag = false;
                        break LABEL;
                    }
                    else{
                        if(c=='}'){
                            tmp = stack.pop();
                            if(tmp!='{'){
                                flag = false;
                                break LABEL;
                            }
                        }
                        else if(c==']'){
                            tmp = stack.pop();
                            if(tmp!='['){
                                flag = false;
                                break LABEL;
                            }
                        }
                        else{
                            tmp = stack.pop();
                            if(tmp!='('){
                                flag = false;
                                break LABEL;
                            }
                        }
                    }
                }
            }
            
            if(!stack.isEmpty()) flag = false;
            
            if(flag) answer++;
        }

        return answer;
    }
}