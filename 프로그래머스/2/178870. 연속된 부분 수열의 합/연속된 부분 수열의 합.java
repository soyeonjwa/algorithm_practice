import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length;
        
        int[] subSum = new int[sequence.length+1];
        for(int i=0;i<sequence.length;i++){
            subSum[i+1] = subSum[i] + sequence[i];
        }
        
        int start = 0;
        int end = 1;
        
        while(start < end){
            if(end>sequence.length) break;
            int sum = subSum[end] - subSum[start];

            if(k > sum){                
                end++;
            }
            else{
                if(k==sum){
                   if(answer[1]-answer[0] > (end - start - 1)){
                        answer[0] = start;
                        answer[1] = end-1;
                    }
                }
                start++;
            }
        }
        
        return answer;
    }
}