import java.util.*;

class Solution {
    public ArrayList<String> solution(String[] expressions) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> unknown = new ArrayList<>();
        ArrayList<String> known = new ArrayList<>();
        
        for(String s : expressions){
            if(s.contains("X")){
                unknown.add(s);
            }
            else{
                known.add(s);
            }
        }
        
        ArrayList<Integer> formation = new ArrayList<>();
        for(int i=2;i<=9;i++){
            boolean flag = true;
            
            for(String x : known){
                if(!judgeKnown(x, i)){
                    flag = false;
                }
            }
            
            for(String x : unknown){
                if(!judgeUnKnown(x, i)){
                    flag = false;
                }
            }
            
            if(flag){
                formation.add(i);
            }
        }
        
        for(String x : unknown){
            HashSet<Integer> results = new HashSet<>();
            int result =0;
            ArrayList<String> exp = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(x);

            for(int i=0;i<5;i++){
                exp.add(st.nextToken());            
            }
        
            
            for(int f : formation){
                int a = formationTo10(exp.get(0), f);
                int b = formationTo10(exp.get(2), f);
                
                if(exp.get(1).equals("+")){
                    result = tenToFormation(a+b, f);
                    results.add(result);
                }
                else{
                    result = tenToFormation(a-b, f);
                    results.add(result);
                }
            }
            
            
            
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<=3;i++){
                sb.append(exp.get(i)).append(" ");
            }
            
            if(results.size()==1){
                sb.append(result);
            }
            else{
                sb.append("?");
            }
            
            answer.add(sb.toString());
        }
        
        return answer;
    }
    
    static boolean judgeKnown(String expression, int f){
        ArrayList<String> exp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression);
        
        for(int i=0;i<5;i++){
            exp.add(st.nextToken());            
        }
        
        int answer = formationTo10(exp.get(0), f);
        if(answer==-1) return false;
        
        int x = formationTo10(exp.get(2), f);
        if(x == -1) return false;
            
        if(exp.get(1).equals("+")){
            answer += x;
        }
        else{
            answer-=x;
        }
        
        x = formationTo10(exp.get(4), f);
        if(x!=-1 && answer == x){
            return true;
        }
        return false;
    }
    
    static boolean judgeUnKnown(String expression, int f){
        ArrayList<String> exp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression);
        
        for(int i=0;i<5;i++){
            exp.add(st.nextToken());            
        }
        
        int answer = formationTo10(exp.get(0), f);
        if(answer==-1) return false;
        
        int x = formationTo10(exp.get(2), f);
        if(x == -1) return false;
        
        return true;
    }
    
    static int formationTo10(String x, int f){
        int ret = 0;
        int k = 1;
        for(int i=x.length()-1;i>=0;i--){
            if((x.charAt(i)-'0')>=f) return -1;
            
            ret += ((x.charAt(i)-'0')*k);
            k *= f;
        }
        return ret;
    }
    
    static int tenToFormation(int x, int f){
        int ret = 0;
        int k = 1;
        while(x>0){
            ret += ((x%f)*k);
            
            k*=10;
            x/=f;
        }
        return ret;
    }
    
}