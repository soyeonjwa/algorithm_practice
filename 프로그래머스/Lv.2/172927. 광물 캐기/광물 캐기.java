import java.util.*;

class Solution {
    
    static int[][] pirodo = {
        {1,1,1},
        {5,1,1},
        {25,5,1}
    };
    
    static int[] pickOrder, mineralOrder;
    static int pickSum = 0;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        for(int x:picks) pickSum += x;
        
        pickOrder = new int[pickSum];
        mineralOrder = new int[minerals.length];
        
        for(int i=0;i<minerals.length;i++){
            if(minerals[i].equals("diamond")) mineralOrder[i] = 0;
            else if(minerals[i].equals("iron")) mineralOrder[i] = 1;
            else mineralOrder[i] = 2;
        }
        
        combination(0,picks);
        
        return answer;
    }
    
    static void combination(int idx, int[] picks){
        if(idx >= pickSum){
            
            int sum = 0;
            int index = 0;
            
            LABEL : for(int pick : pickOrder){
                int cnt = 5;
                
                while(cnt>0){ 
                    if(index >= mineralOrder.length) break LABEL;
                    
                    sum+=pirodo[pick][mineralOrder[index++]];
                    cnt--;
                }
            }
            
            answer = Math.min(answer, sum);
            
            return;
        }
        
        for(int i=0;i<3;i++){
            if(picks[i]>=1){
                picks[i]--;
                pickOrder[idx] = i;
                combination(idx+1, picks);
                picks[i]++;
            }
        }
    }
    
}