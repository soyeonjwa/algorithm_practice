import java.util.*;
import java.awt.Point;

class Solution {
    
    static int[] discountPercent = new int[]{10,20,30,40};
    static Point ans = new Point(0,0);
    
    public int[] solution(int[][] users, int[] emoticons) {
        combination(0, new LinkedList<Integer>(),users, emoticons);
        return new int[]{ans.x, ans.y};
    }
    
    static void combination(int cur, LinkedList<Integer> result, int[][] users, int[] emoticons){
        if(cur==emoticons.length){
            Point res = calculate(result, users, emoticons);
            
            if(res.x > ans.x){
                ans = res;
            }
            else if(res.x==ans.x){
                if(res.y > ans.y){
                    ans = res;
                }
            }
            
            return;
        }
        
        for(int i=0;i<4;i++){
            result.addLast(discountPercent[i]);
            combination(cur+1, result, users, emoticons);
            result.removeLast();
        }
    }
    
    static Point calculate(LinkedList<Integer> result, int[][] users, int[] emoticons){
        int accession = 0;
        int salesPrice = 0;
        
        for(int[] user : users){
            int buy = 0;
            
            for(int i=0;i<result.size();i++){
                int percent = result.get(i);
                if(percent < user[0]) continue;
                
                buy += (100-percent)*emoticons[i]/100;
            }

            if(buy >= user[1]){
                accession++;
            }
            else{
                salesPrice += buy;
            }
        }
        
        return new Point(accession, salesPrice);
    }
}