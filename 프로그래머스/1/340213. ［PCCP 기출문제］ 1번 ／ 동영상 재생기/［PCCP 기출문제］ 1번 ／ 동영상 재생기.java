import java.util.*;

class Solution {
    
    static class Time{
        int totalSecond;
        
        Time(String minute, String second){
            this.totalSecond = Integer.parseInt(minute) * 60 + Integer.parseInt(second);
        }
        
        public String timeToString(){
            int minute = this.totalSecond/60;
            int second = this.totalSecond%60;
            
            StringBuilder sb = new StringBuilder();
            if(minute<10){
                sb.append("0");
            }
            
            sb.append(minute);
            sb.append(":");
            
            if(second<10){
                sb.append("0");
            }
            sb.append(second);
            
            return sb.toString();
        }
        
        public void setTime(int time){
            this.totalSecond += time;
        }
        
        public void setZero(){
            this.totalSecond = 0;
        }
        
        public void setEnd(int time){
            this.totalSecond = time;
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringTokenizer st = new StringTokenizer(video_len, ":");
        Time videoLen = new Time(st.nextToken(), st.nextToken());
        
        st = new StringTokenizer(pos, ":");
        Time cur = new Time(st.nextToken(), st.nextToken());
        
        st = new StringTokenizer(op_start, ":");
        Time opStart = new Time(st.nextToken(), st.nextToken());
        
        st = new StringTokenizer(op_end, ":");
        Time opEnd = new Time(st.nextToken(), st.nextToken());
        
        for(String command : commands){
            if(cur.totalSecond>=opStart.totalSecond && cur.totalSecond<=opEnd.totalSecond){
                cur.setEnd(opEnd.totalSecond);
            }
            
            if(command.equals("prev")){
                if(cur.totalSecond-10<0){
                    cur.setZero();
                    continue;
                }
                
                cur.setTime(-10);
            }
            
            if(command.equals("next")){
                if(cur.totalSecond+10>videoLen.totalSecond){
                    cur.setEnd(videoLen.totalSecond);
                    continue;
                }
                
                cur.setTime(10);
            }
        }
        
        if(cur.totalSecond>=opStart.totalSecond && cur.totalSecond<=opEnd.totalSecond){
                cur.setEnd(opEnd.totalSecond);
        }
        
        return cur.timeToString();
    }
}