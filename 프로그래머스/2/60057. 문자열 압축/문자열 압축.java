import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
 
        for(int l=1;l<=s.length()/2;l++){
            String newStr = "";
            
            for(int i=0;i<s.length();){
                if(i>s.length()-l*2) {
                    newStr += s.substring(i,s.length());
                    break;
                }
                
                int j=i+l;
                String tmp = s.substring(i, i+l);
                
                if(!tmp.equals(s.substring(j,j+l))){
                    newStr += s.substring(i,i+l);
                    i+=l;
                    continue;
                }
                
                int cnt = 1;
                for(;j<=s.length()-l;j+=l){
                    if(!tmp.equals(s.substring(j,j+l))){
                        break;
                    }
                    
                    cnt++;
                }
                
                newStr += (Integer.toString(cnt));
                newStr += tmp;
                i+=l*cnt;
            }
            
            
            answer = Math.min(answer, newStr.length());
        }
        
        return answer;
    }
}