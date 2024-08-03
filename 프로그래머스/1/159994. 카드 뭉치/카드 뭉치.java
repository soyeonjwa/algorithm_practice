import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal){
        String answer = "Yes";
        
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        
        for(String card : cards1){
            queue1.add(card);
        }
        
        for(String card : cards2){
            queue2.add(card);
        }
        
        for(String card : goal){
            if(!queue1.isEmpty() && queue1.peek().equals(card)){
                queue1.poll();
                continue;
            }
            
            if(!queue2.isEmpty() && queue2.peek().equals(card)){
                queue2.poll();
                continue;
            }
            
            answer = "No";
            break;
        }
        
        return answer;
    }
}