import java.util.*;

class Solution {
    
    static class Log{
        int startTime;
        int endTime;
        
        Log(int hour, int minute, double second, double duringTime){
            this.endTime =(int)(hour*60*60*1000+minute*60*1000+second*1000);
            this.startTime = this.endTime-(int)(duringTime*1000)+1;
        }
    }
    
    
    public int solution(String[] lines) {
        
        ArrayList<Log> logArr = new ArrayList<>();
        
        for(String line : lines){
            StringTokenizer st = new StringTokenizer(line);
            st.nextToken();
            
            String time = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(time, ":");
            
            int minute = Integer.parseInt(st2.nextToken());
            int second = Integer.parseInt(st2.nextToken());
            double milisecond = Double.parseDouble(st2.nextToken());
            
            String dTStr = st.nextToken().replace("s","");
            
            double duringTime = Double.parseDouble(dTStr);
            
            logArr.add(new Log(minute, second, milisecond, duringTime));
        }
        
        
        int answer = 0;
        
        for(int i=0;i<logArr.size();i++){
            int cnt = 1;
            for(int j=i+1;j<logArr.size();j++){
                
                if(logArr.get(j).startTime<logArr.get(i).endTime+1000) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        
        
        
        return answer;
    }
}                                          