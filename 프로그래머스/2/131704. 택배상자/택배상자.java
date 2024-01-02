import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subContainer = new Stack<>();
        Queue<Integer> container = new LinkedList<>();
        
        for(int i=1;i<=order.length;i++) container.add(i);
        
        int idx = 0;
        int ans = 0;
        
        while(!container.isEmpty()){
            int cur = container.poll();
            
            subContainer.add(cur);
            
            while(!subContainer.isEmpty() && subContainer.peek()==order[idx]){
                ans ++;
                idx ++;
                subContainer.pop();
            }
        }
        
        return ans;
    }
}