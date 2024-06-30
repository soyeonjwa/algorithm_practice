import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] operations) {
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>((a,b)->(a>b)?-1:1);
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        
        for(String operation : operations){
            StringTokenizer st = new StringTokenizer(operation);
            
            switch(st.nextToken()){
                case "I":{
                    int x = Integer.parseInt(st.nextToken());
                    
                    if(hm.containsKey(x)){
                        int num = hm.get(x);
                        hm.replace(x, num);
                    }
                    else{
                        hm.put(x,1);
                    }
                    
                    bigQueue.add(x);
                    smallQueue.add(x);
                    
                    break;
                }
                case "D":{                    
                    if(Integer.parseInt(st.nextToken())==-1){
                        while(!smallQueue.isEmpty()){
                            int x = smallQueue.poll();
                            
                            if(hm.containsKey(x)){
                                if(hm.get(x)==1){
                                    hm.remove(x);
                                }
                                else{
                                    hm.replace(x, hm.get(x)-1);
                                }
                                
                                
                                break;
                            }
                        }
                    }
                    else{
                        while(!bigQueue.isEmpty()){
                            int x = bigQueue.poll();
                            
                            if(hm.containsKey(x)){
                                if(hm.get(x)==1){
                                    hm.remove(x);
                                }
                                else{
                                    hm.replace(x, hm.get(x)-1);
                                }
                                
                                
                                break;
                            }
                        }
                    }
                    
                    break;
                }
                default:{
                    break;
                }
            }

        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        if(hm.size()==0){
            answer.add(0);
            answer.add(0);
            
            return answer;
        }
        
        
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;
        
        for(int x : hm.keySet()){
            smallest = Math.min(x, smallest);
            biggest = Math.max(x, biggest);
        }
        
        answer.add(biggest);
        answer.add(smallest);
        
        return answer;
    }
}