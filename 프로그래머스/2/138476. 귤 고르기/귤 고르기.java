import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int x : tangerine){
            if(hashmap.containsKey(x)){
                int y = hashmap.get(x);
                hashmap.put(x, y+1);
            }
            else{
                hashmap.put(x, 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return a>b?-1:1;
        });
        for(int value : hashmap.values()){
            pq.add(value);
        }
        
        while(!pq.isEmpty() && k>0){
            answer++;
            k-=pq.poll();
        }
        return answer;
    }
}