import java.util.*;

class Solution {
    
    
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        for(String[] arr : clothes){
            ArrayList<String> arrList = new ArrayList<>();

            if(hm.containsKey(arr[1])){
                arrList = hm.get(arr[1]);
                arrList.add(arr[0]);
                hm.replace(arr[1], arrList);
                continue;
            }
            arrList.add(arr[0]);
            
            hm.put(arr[1], arrList);
        }
        
        int answer = 1;
        for(String s : hm.keySet()){
            answer *= (hm.get(s).size()+1); 
        }
        
        
        return answer-1;
    }
    

}