import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            q.add((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
        }
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()){
            int cnt = 1;
            int cur = q.poll();
            
            while(!q.isEmpty()){
                if(q.peek()>cur){
                    break;
                }
                
                cnt++;
                q.poll();
            }
            
            answer.add(cnt);
        }
        
        return answer;
    }
}