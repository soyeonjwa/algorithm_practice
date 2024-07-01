import java.util.*;

class Solution {
    
    static int answer = 0;
    static ArrayList<Integer> cnt = new ArrayList<>();
    
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
        
        
        for(String c : hm.keySet()){
            cnt.add(hm.get(c).size());
        }
        
        combination(0, true, 1, cnt.size()-1);
        combination(0, false, 1, cnt.size()-1);
        
        return answer-1;
    }
    
    public static void combination(int index, boolean include, int cur, int maxIndex){
        if(include){
            cur*=(cnt.get(index));
        }
        
        if(index == maxIndex){
            answer+= cur;
            return;
        }
        
        combination(index+1, true, cur, maxIndex);
        combination(index+1, false, cur, maxIndex);
        
    }
}