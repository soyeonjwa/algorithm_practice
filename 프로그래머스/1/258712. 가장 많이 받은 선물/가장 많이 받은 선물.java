import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> friendIndex = new HashMap<>();
        
        int idx = 0;
        for(String friend : friends){
            friendIndex.put(friend, idx++);
        }
        
        int[][] giftList = new int[friends.length][friends.length];

        for(String gift : gifts){
            StringTokenizer st = new StringTokenizer(gift);
            
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            
            giftList[friendIndex.get(s1)][friendIndex.get(s2)]++;
        }
        
        int[] giftLevel = new int[friends.length];
        for(int i=0;i<friends.length;i++){
            int give = 0;
            int receive = 0;
            
            for(int j=0;j<friends.length;j++){
                if(i==j) continue;
                
                give += giftList[i][j];
                receive += giftList[j][i];
            }
            
            giftLevel[i] = give - receive;
        }
        
        int answer = 0;
        for(int i=0;i<friends.length;i++){
            int cnt = 0;
            
            for(int j=0;j<friends.length;j++){
                if(i==j) continue;
                
                if(giftList[i][j]>giftList[j][i]) cnt++;
                if(giftList[i][j]==giftList[j][i] && giftLevel[i] > giftLevel[j]) cnt++;
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}