import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        
        int answer = end;
        
        while(start <= end){
            int mid = (start+end)/2;
            long takenTime = 0;
            
            for(int p=0;p<diffs.length;p++){
                takenTime += times[p];
                
                if(diffs[p]!=1 && diffs[p]>mid){
                    takenTime += ((diffs[p]-mid)*((times[p-1])+times[p]));
                }
            }
            
            if(takenTime <= limit){
                answer = Math.min(answer, mid);
                end = mid-1;
            }
            else{
                start = mid+1;
            }
            
            if(takenTime==limit) break;
        }
        
        return answer;
    }
}