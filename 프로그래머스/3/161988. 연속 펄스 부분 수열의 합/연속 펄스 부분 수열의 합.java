import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        boolean pulse = true;
        long answer = 0;
        
        long pulse1 = 0;
        long pulse2 = 0;
        
        for(int num : sequence){
            pulse1 += pulse? num : num * -1;
            pulse2 += pulse? num * -1 : num;
            
            
            pulse1 = Math.max(0, pulse1);
            pulse2 = Math.max(0, pulse2);
            
            answer = Math.max(answer, Math.max(pulse1, pulse2));
            
            pulse = !pulse;
        }
        
        
        return answer;
    }
}