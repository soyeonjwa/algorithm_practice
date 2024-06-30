import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a>b? 1 : -1);
        for(int s : scoville){
            pq.add(s);
        }
        
        int answer = 0;
        
        while(true){
            if(pq.size() < 2 || pq.peek() >= K){
                break;
            }
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            pq.add(s1+s2*2);
            answer++;
        }
        
        if(pq.size()<2 && pq.peek()<K){
            answer = -1;
        }
        
        return answer;
    }
}