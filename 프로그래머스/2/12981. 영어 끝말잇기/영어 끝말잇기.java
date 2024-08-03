import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        
        int order = 1;
        set.add(words[0]);
        
        boolean can = false;
        for(;order<words.length;order++){
            System.out.println(words[order]);
            if(words[order].charAt(0)!=words[order-1].charAt(words[order-1].length()-1)){
                can = true;
                break;
            }
            
            if(set.contains(words[order])){
                can = true;
                break;
            }
            
            
            set.add(words[order]);
        }

        if(can){
            order++;
            
            if(order%n==0){
                answer[0] = n;
                answer[1] = order/n;
            }
            else{
                answer[0] = order%n;
                answer[1] = order/n+1;
            }
        }
        return answer;
    }
}